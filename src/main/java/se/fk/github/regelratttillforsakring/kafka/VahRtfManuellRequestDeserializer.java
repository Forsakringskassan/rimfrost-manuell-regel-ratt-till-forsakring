package se.fk.github.regelratttillforsakring.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.github.regelratttillforsakring.presentation.dto.VahRtfManuellRequest;

public class VahRtfManuellRequestDeserializer extends ObjectMapperDeserializer<VahRtfManuellRequest>
{
   public VahRtfManuellRequestDeserializer()
   {
      super(VahRtfManuellRequest.class);
   }
}
