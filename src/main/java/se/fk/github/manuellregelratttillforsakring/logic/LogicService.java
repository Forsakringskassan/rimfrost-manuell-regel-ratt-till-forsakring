package se.fk.github.manuellregelratttillforsakring.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.manuellregelratttillforsakring.integration.IntegrationService;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellRequest;

@ApplicationScoped
public class LogicService
{

   @Inject
   IntegrationService integrationService;

   @Inject
   LogicMapper logicMapper;

   public void callManualTask(LogicManuellRequest request)
   {
      var integrationRequest = logicMapper.toIntegration(request);
      integrationService.callManualTask(integrationRequest);
   }
}
