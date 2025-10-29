package se.fk.github.regelratttillforsakring.logic.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface LogicManuellResponse
{
   UUID processId();

   Boolean isBokford();
}
