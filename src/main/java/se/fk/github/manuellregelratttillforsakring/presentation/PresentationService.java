package se.fk.github.manuellregelratttillforsakring.presentation;

import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.MDC;
import se.fk.github.logging.callerinfo.model.MDCKeys;
import se.fk.github.manuellregelratttillforsakring.logic.LogicService;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellRequestPayload;

import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PresentationService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(PresentationService.class);

   @Inject
   LogicService logicService;

   @Inject
   PresentationMapper presentationMapper;

   @Incoming("manuell-vah-rtf-request")
   @Outgoing("manuell-vah-rtf-response")
   public void process(VahRtfManuellRequestPayload payload)
   {
      MDC.put(MDCKeys.PROCESSID.name(), payload.getProcessId().toString());
      LOGGER.info("VahRtf manuell request payload mottaget med id: " + payload.getProcessId());
      var presentationRequest = presentationMapper.fromExternalApi(payload);
      var logicRequest = presentationMapper.toLogic(presentationRequest);
      logicService.callManualTask(logicRequest);
   }
}
