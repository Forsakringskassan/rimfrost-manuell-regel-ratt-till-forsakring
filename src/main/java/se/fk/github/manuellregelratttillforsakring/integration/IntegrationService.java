package se.fk.github.manuellregelratttillforsakring.integration;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.github.manuellregelratttillforsakring.integration.dto.IntegrationManuellRequest;
import se.fk.gradle.examples.asyncapi.ExempelRtfRequestPayload;

@ApplicationScoped
public class IntegrationService
{

   @ConfigProperty(name = "oul.api.base-url")
   String oulUrl;

   @Inject
   IntegrationMapper integrationMapper;

   @Inject
   @Channel("rtf-oul-request")
   @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1024)
   Emitter<ExempelRtfRequestPayload> emitter;

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationService.class);

   public void callManualTask(IntegrationManuellRequest externalRequest)
   {
      LOGGER.info("Manuell Request mottaget med ID: " + externalRequest.processId());
      var request = integrationMapper.toExternalApi(externalRequest);
      var metadata = OutgoingKafkaRecordMetadata.<String> builder().withKey(request.getProcessId()).build();
      Message<ExempelRtfRequestPayload> msg = Message.of(request).addMetadata(metadata);
      emitter.send(msg);
      LOGGER.info("Manuell Task-request skickad vidare till OUL med ID: " + request.getProcessId());
   }
}
