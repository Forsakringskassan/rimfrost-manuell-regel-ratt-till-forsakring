package se.fk.github.manuellregelratttillforsakring.integration.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = VahRtfManuellResponse.class)
public interface VahRtfManuellResponse
{
   UUID processId();

   String personnummer();

  boolean resultat();
}
