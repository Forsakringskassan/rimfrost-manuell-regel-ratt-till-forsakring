package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.manuellregelratttillforsakring.integration.dto.*;
import se.fk.gradle.examples.asyncapi.ExempelRtfRequestPayload;
import se.fk.gradle.examples.asyncapi.ExempelRtfResponsePayload;

import java.util.UUID;

@ApplicationScoped
public class IntegrationMapper
{
   public ExempelRtfRequestPayload toExternalApi(IntegrationManuellRequest integrationRequest)
   {
      var payload = new ExempelRtfRequestPayload();
      payload.setProcessId(integrationRequest.processId().toString());
      payload.setPersonNummer(integrationRequest.personnummer());
      return payload;
   }

   public IntegrationManuellResponse fromExternalApi(ExempelRtfResponsePayload externalResponse)
   {
      return ImmutableIntegrationManuellResponse.builder()
            .processId(UUID.fromString(externalResponse.getProcessId()))
            .personnummer(externalResponse.getPersonNummer())
            .rattTillForsakring(externalResponse.getRattTillForsakring())
            .build();
   }
}
