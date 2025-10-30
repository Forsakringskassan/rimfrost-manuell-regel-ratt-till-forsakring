package se.fk.github.manuellregelratttillforsakring.presentation;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.*;
import org.slf4j.MDC;
import se.fk.github.logging.callerinfo.model.MDCKeys;
import se.fk.github.manuellregelratttillforsakring.logic.LogicService;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellResponse;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellRequestPayload;

import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellResponsePayload;

@ApplicationScoped
public class PresentationService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(PresentationService.class);

   @Inject
   LogicService logicService;

   @Inject
   PresentationMapper presentationMapper;

   @Inject
   @Channel("vah-rtf-manuell-responses")
   @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1024)
   Emitter<VahRtfManuellResponsePayload> emitter;

   @Incoming("vah-rtf-manuell-request")
   public void process(VahRtfManuellRequestPayload payload)
   {
      MDC.put(MDCKeys.PROCESSID.name(), payload.getProcessId());
      LOGGER.info("VahRtf manuell request payload mottaget med id: " + payload.getProcessId());
      var presentationRequest = presentationMapper.fromExternalApi(payload);
      var logicRequest = presentationMapper.toLogic(presentationRequest);
      logicService.callManualTask(logicRequest);
   }

   public void reply(LogicManuellResponse externalResponse)
   {
      LOGGER.info("Manuell task-response skickad tillbaka med ID: " + externalResponse.processId());
      var response = presentationMapper.toPresentation(externalResponse);
      var outgoingResponse = presentationMapper.toExternalApi(response);
      var metadata = OutgoingKafkaRecordMetadata.<String> builder().withKey(outgoingResponse.getProcessId()).build();
      Message<VahRtfManuellResponsePayload> msg = Message.of(outgoingResponse).addMetadata(metadata);
      emitter.send(msg);
      LOGGER.info("Skickat manuell task-response via kafka med ID: " + externalResponse.processId());
   }
}
