package se.fk.github.manuellregelratttillforsakring.integration.dto;

import java.util.UUID;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = ImmutableOulResponse.class)
public interface OulResponse
{
   UUID processId();

   String personNummer();

   boolean resultat();
}
