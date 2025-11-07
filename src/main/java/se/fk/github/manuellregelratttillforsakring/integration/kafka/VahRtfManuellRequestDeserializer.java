package se.fk.github.manuellregelratttillforsakring.integration.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.rimfrost.VahRtfManuellRequestMessagePayload;

public class VahRtfManuellRequestDeserializer extends ObjectMapperDeserializer<VahRtfManuellRequestMessagePayload>
{
   public VahRtfManuellRequestDeserializer()
   {
      super(VahRtfManuellRequestMessagePayload.class);
   }
}
