package se.fk.github.manuellregelratttillforsakring.logic;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.manuellregelratttillforsakring.integration.dto.ImmutableIntegrationManuellRequest;
import se.fk.github.manuellregelratttillforsakring.integration.dto.IntegrationManuellRequest;
import se.fk.github.manuellregelratttillforsakring.integration.dto.IntegrationManuellResponse;
import se.fk.github.manuellregelratttillforsakring.logic.dto.ImmutableLogicManuellResponse;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellResponse;

@ApplicationScoped
public class LogicMapper
{
   public LogicManuellResponse toLogic(IntegrationManuellResponse external)
   {
      return ImmutableLogicManuellResponse.builder()
            .processId(external.processId())
            .personnummer(external.personnummer())
            .rattTillForsakring(external.rattTillForsakring())
            .build();
   }

   public IntegrationManuellRequest toIntegration(LogicManuellRequest logic)
   {
      return ImmutableIntegrationManuellRequest.builder()
            .processId(logic.processId())
            .personnummer(logic.personnummer())
            .build();
   }
}
