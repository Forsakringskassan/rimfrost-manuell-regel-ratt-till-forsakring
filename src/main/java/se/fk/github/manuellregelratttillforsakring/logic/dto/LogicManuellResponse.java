package se.fk.github.manuellregelratttillforsakring.logic.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface LogicManuellResponse
{
   UUID processId();

   String personnummer();

   boolean rattTillForsakring();
}
