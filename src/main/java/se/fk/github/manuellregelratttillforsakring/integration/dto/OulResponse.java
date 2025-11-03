package se.fk.github.manuellregelratttillforsakring.integration.dto;

import java.util.UUID;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Value.Immutable
@JsonDeserialize(as = OulResponse.class)
public interface OulResponse {
    UUID processId();

   String personnummer();

  boolean resultat();
}
