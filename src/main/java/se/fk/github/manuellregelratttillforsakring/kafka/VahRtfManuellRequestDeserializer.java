package se.fk.github.manuellregelratttillforsakring.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellRequestPayload;

public class VahRtfManuellRequestDeserializer extends ObjectMapperDeserializer<VahRtfManuellRequestPayload>
{
   public VahRtfManuellRequestDeserializer()
   {
      super(VahRtfManuellRequestPayload.class);
   }
}
