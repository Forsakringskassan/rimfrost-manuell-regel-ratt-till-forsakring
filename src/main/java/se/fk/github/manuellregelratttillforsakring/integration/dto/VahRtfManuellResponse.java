package se.fk.github.manuellregelratttillforsakring.integration.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableVahRtfManuellResponse.class)
public interface VahRtfManuellResponse
{
   UUID processId();

   boolean result();
}
