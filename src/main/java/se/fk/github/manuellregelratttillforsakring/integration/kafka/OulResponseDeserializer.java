package se.fk.github.manuellregelratttillforsakring.integration.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessagePayload;

public class OulResponseDeserializer extends ObjectMapperDeserializer<OperativtUppgiftslagerResponseMessagePayload>
{
   public OulResponseDeserializer()
   {
      super(OperativtUppgiftslagerResponseMessagePayload.class);
   }
}
