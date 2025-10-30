package se.fk.github.manuellregelratttillforsakring.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.github.manuellregelratttillforsakring.presentation.dto.VahRtfManuellRequest;

public class VahRtfManuellRequestDeserializer extends ObjectMapperDeserializer<VahRtfManuellRequest>
{
   public VahRtfManuellRequestDeserializer()
   {
      super(VahRtfManuellRequest.class);
   }
}
