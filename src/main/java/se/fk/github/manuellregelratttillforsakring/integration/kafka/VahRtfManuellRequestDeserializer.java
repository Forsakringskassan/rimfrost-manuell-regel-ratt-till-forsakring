package se.fk.github.manuellregelratttillforsakring.integration.kafka;

import com.fasterxml.jackson.core.type.TypeReference;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.github.manuellregelratttillforsakring.integration.dto.CloudEvent;
import se.fk.github.manuellregelratttillforsakring.integration.dto.VahRtfManuellRequest;

public class VahRtfManuellRequestDeserializer extends ObjectMapperDeserializer<CloudEvent<VahRtfManuellRequest>>
{
   public VahRtfManuellRequestDeserializer()
   {
      super(new TypeReference<CloudEvent<VahRtfManuellRequest>>()
      {
      });
   }
}
