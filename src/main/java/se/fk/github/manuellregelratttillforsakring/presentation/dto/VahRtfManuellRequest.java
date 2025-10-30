package se.fk.github.manuellregelratttillforsakring.presentation.dto;

import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableVahRtfManuellRequest.class)
public interface VahRtfManuellRequest
{
   UUID processId();

   String personnummer();
}
