package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import se.fk.github.logging.callerinfo.model.MDCKeys;
import se.fk.github.manuellregelratttillforsakring.integration.dto.CloudEvent;
import se.fk.github.manuellregelratttillforsakring.integration.dto.OulRequest;
import se.fk.github.manuellregelratttillforsakring.integration.dto.OulResponse;
import se.fk.github.manuellregelratttillforsakring.integration.dto.VahRtfManuellRequest;
import se.fk.github.manuellregelratttillforsakring.integration.dto.VahRtfManuellResponse;

@ApplicationScoped
public class IntegrationServiceConsumer
{
   @Inject
   IntegrationMapper integrationMapper;

   private final HashMap<UUID, CloudEvent<VahRtfManuellRequest>> rtfRequests = new HashMap<UUID, CloudEvent<VahRtfManuellRequest>>();

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceConsumer.class);

   @Incoming("vah-rtf-manuell-requests")
   @Outgoing("operativt-uppgiftslager-requests")
   public OulRequest onRtfManuellRequest(CloudEvent<VahRtfManuellRequest> rtfRequest)
   {
      MDC.put(MDCKeys.PROCESSID.name(), rtfRequest.data().processId().toString());
      LOGGER.info("VahRtfManuellRequest received with ID: " + rtfRequest.data().processId());
      rtfRequests.put(rtfRequest.data().processId(), rtfRequest);
      LOGGER.info("Sent OulRequest with ID: " + rtfRequest.data().processId());
      return integrationMapper.toOperativtUppgiftsLagerRequest(rtfRequest.data());
   }

   @Incoming("operativt-uppgiftslager-responses")
   @Outgoing("vah-rtf-manuell-responses")
   public CloudEvent<VahRtfManuellResponse> onOulReponse(OulResponse oulResponse)
   {
      LOGGER.info("OULResponse received with ID: " + oulResponse.processId());
      var rtfRequest = rtfRequests.get(oulResponse.processId());
      LOGGER.info("Sent RtfResponse with ID: " + rtfRequest.data().processId());
      return integrationMapper.toRtfResponse(oulResponse, rtfRequest);
   }
}
