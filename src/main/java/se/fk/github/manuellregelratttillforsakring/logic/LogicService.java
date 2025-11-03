package se.fk.github.manuellregelratttillforsakring.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.manuellregelratttillforsakring.integration.IntegrationServiceProducer;
import se.fk.github.manuellregelratttillforsakring.integration.dto.IntegrationManuellResponse;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.presentation.PresentationService;

@ApplicationScoped
public class LogicService
{

   @Inject
   IntegrationServiceProducer integrationService;

   @Inject
   PresentationService presentationService;

   @Inject
   LogicMapper logicMapper;

   public void callManualTask(LogicManuellRequest request)
   {
      var integrationRequest = logicMapper.toIntegration(request);
      integrationService.callManualTask(integrationRequest);
   }

   public void responseForManuelTask(IntegrationManuellResponse integrationResponse)
   {
      var logicResponse = logicMapper.toLogic(integrationResponse);
      presentationService.reply(logicResponse);
   }
}
