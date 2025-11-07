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
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessagePayload;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessagePayload;
import se.fk.rimfrost.VahRtfManuellRequestMessagePayload;
import se.fk.rimfrost.VahRtfManuellResponseMessagePayload;

@ApplicationScoped
public class IntegrationServiceProcessor
{
   @Inject
   IntegrationMapper integrationMapper;

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceProcessor.class);

   @Incoming("vah-rtf-manuell-requests")
   @Outgoing("operativt-uppgiftslager-requests")
   public OperativtUppgiftslagerRequestMessagePayload onRtfManuellRequest(VahRtfManuellRequestMessagePayload rtfRequest)
   {
      MDC.put(MDCKeys.PROCESSID.name(), rtfRequest.getData().getProcessId());
      LOGGER.info("VahRtfManuellRequest received with ID: " + rtfRequest.getData().getProcessId());
      return integrationMapper.toOperativtUppgiftsLagerRequest(rtfRequest);
   }

   @Incoming("operativt-uppgiftslager-responses")
   @Outgoing("vah-rtf-manuell-responses")
   public VahRtfManuellResponseMessagePayload onOulReponse(OperativtUppgiftslagerResponseMessagePayload oulResponse)
   {
      LOGGER.info("OULResponse received with ID: " + oulResponse.getData().getProcessId());
      return integrationMapper.toRtfResponse(oulResponse);
   }
}
