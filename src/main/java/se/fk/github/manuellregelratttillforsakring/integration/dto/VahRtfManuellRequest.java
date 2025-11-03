package se.fk.github.manuellregelratttillforsakring.integration.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.UUID;

@Value.Immutable
@JsonDeserialize(as = ImmutableVahRtfManuellRequest.class)
public interface VahRtfManuellRequest
{
   UUID processId();

   String pnr();
}
