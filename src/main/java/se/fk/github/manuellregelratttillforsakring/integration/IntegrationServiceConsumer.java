package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import se.fk.github.logging.callerinfo.model.MDCKeys;
import se.fk.github.manuellregelratttillforsakring.integration.dto.CloudEvent;
import se.fk.github.manuellregelratttillforsakring.integration.dto.OulResponse;
import se.fk.github.manuellregelratttillforsakring.integration.dto.VahRtfManuellRequest;

@ApplicationScoped
public class IntegrationServiceConsumer
{

   @Inject
   IntegrationMapper integrationMapper;

   @Inject
   IntegrationServiceProducer producer;

   private final HashMap<UUID, CloudEvent<VahRtfManuellRequest>> rtfRequests = new HashMap<UUID, CloudEvent<VahRtfManuellRequest>>();

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceConsumer.class);

   @Incoming("vah-rtf-manuell-request")
   public void onRtfManuellRequest(CloudEvent<VahRtfManuellRequest> rtfRequest)
   {
      MDC.put(MDCKeys.PROCESSID.name(), rtfRequest.data().processId().toString());
      LOGGER.info("VahRtfManuellRequest received with ID: " + rtfRequest.data().processId());
      rtfRequests.put(rtfRequest.data().processId(), rtfRequest);
      var oulRequest = integrationMapper.toOperativtUppgiftsLagerRequest(rtfRequest.data());
      producer.sendOulRequest(oulRequest);
   }

   @Incoming("operativt-uppgiftslager-responses")
   public void onOulReponse(OulResponse oulResponse)
   {
      LOGGER.info("OULResponse received with ID: " + oulResponse.processId());
      var rtfRequest = rtfRequests.get(oulResponse.processId());
      var rtfResonse = integrationMapper.toRtfResponse(oulResponse, rtfRequest);
      producer.sendRtfResponse(rtfResonse);
   }

}
