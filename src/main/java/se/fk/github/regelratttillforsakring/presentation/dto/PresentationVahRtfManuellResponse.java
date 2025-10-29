package se.fk.github.regelratttillforsakring.presentation.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface PresentationVahRtfManuellResponse
{
   UUID processId();

   String personnummer();

   Boolean isBokford();
}
