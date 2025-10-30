package se.fk.github.manuellregelratttillforsakring.presentation.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface PresentationVahRtfManuellResponse
{
   UUID processId();

   String personnummer();

   boolean rattTillForsakring();
}
