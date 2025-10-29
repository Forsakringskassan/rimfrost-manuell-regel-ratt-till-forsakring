package se.fk.github.regelratttillforsakring.integration.dto;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public interface IntegrationManuellResponse
{
   UUID processId();

   String personnummer();

   Boolean isBokford();
}
