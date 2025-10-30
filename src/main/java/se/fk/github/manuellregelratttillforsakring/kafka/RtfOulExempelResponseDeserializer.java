package se.fk.github.manuellregelratttillforsakring.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.gradle.examples.asyncapi.ExempelRtfResponsePayload;

public class RtfOulExempelResponseDeserializer extends ObjectMapperDeserializer<ExempelRtfResponsePayload>
{
   public RtfOulExempelResponseDeserializer()
   {
      super(ExempelRtfResponsePayload.class);
   }
}
