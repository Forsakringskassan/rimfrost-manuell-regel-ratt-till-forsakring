package se.fk.github.regelratttillforsakring.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.github.regelratttillforsakring.presentation.dto.VahRtfManuellRequest;

public class VahRtfRequestDeserializer extends ObjectMapperDeserializer<VahRtfManuellRequest>
{
   public VahRtfRequestDeserializer()
   {
      super(VahRtfManuellRequest.class);
   }
}
