package se.fk.github.regelratttillforsakring.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.regelratttillforsakring.integration.OperativUppgiftslagerIntegrationService;
import se.fk.github.regelratttillforsakring.logic.dto.LogicFolkbokfordRequest;
import se.fk.github.regelratttillforsakring.logic.dto.LogicFolkbokfordResponse;

@ApplicationScoped
public class FolkbokfordLogicService
{
//
//   @Inject
//   OperativUppgiftslagerIntegrationService folkbokfordIntegration;
//
//   @Inject
//   LogicMapper logicMapper;
//
//   public LogicFolkbokfordResponse checkFolkbokford(LogicFolkbokfordRequest request)
//   {
//      var integrationRequest = logicMapper.toIntegration(request);
//      var integrationResponse = folkbokfordIntegration.pakallaManuellUppgift(integrationRequest);
//      return logicMapper.toLogic(integrationResponse);
//   }
}
