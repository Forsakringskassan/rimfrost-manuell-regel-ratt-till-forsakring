package se.fk.github.manuellregelratttillforsakring.integration.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.github.manuellregelratttillforsakring.integration.dto.OulResponse;

public class OulResponseDeserializer extends ObjectMapperDeserializer<OulResponse>
{
   public OulResponseDeserializer()
   {
      super(OulResponse.class);
   }
}
