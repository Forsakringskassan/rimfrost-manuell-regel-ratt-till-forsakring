package se.fk.github.manuellregelratttillforsakring.logic.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface LogicManuellRequest
{
   UUID processId();

   String personnummer();
}
