package se.fk.github.manuellregelratttillforsakring.integration;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.github.manuellregelratttillforsakring.integration.dto.IntegrationManuellRequest;
import se.fk.gradle.examples.asyncapi.ExempelRtfRequestPayload;

@ApplicationScoped
public class IntegrationServiceProducer
{

   @Inject
   IntegrationMapper integrationMapper;

   @Inject
   @Channel("operativt-uppgiftslager-requests")
   @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1024)
   Emitter<ExempelRtfRequestPayload> emitter;

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceProducer.class);

   public void callManualTask(IntegrationManuellRequest externalRequest)
   {
      LOGGER.info("Manuell request mottaget med ID: " + externalRequest.processId());
      var request = integrationMapper.toExternalApi(externalRequest);
      var metadata = OutgoingKafkaRecordMetadata.<String> builder().withKey(request.getProcessId()).build();
      Message<ExempelRtfRequestPayload> msg = Message.of(request).addMetadata(metadata);
      emitter.send(msg);
      LOGGER.info("Manuell task-request skickad vidare till OUL med ID: " + request.getProcessId());
   }
}
