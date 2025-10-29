package se.fk.github.regelratttillforsakring.presentation.dto;

import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
//@JsonSerialize(as = ImmutableVahRtfManuellResponse.class)
public interface VahRtfManuellResponse
{
   UUID processId();

   boolean result();
}
