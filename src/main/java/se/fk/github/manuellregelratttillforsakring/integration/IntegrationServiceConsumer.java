package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.fk.github.manuellregelratttillforsakring.logic.LogicService;
import se.fk.gradle.examples.asyncapi.ExempelRtfResponsePayload;

@ApplicationScoped
public class IntegrationServiceConsumer
{

   @Inject
   IntegrationMapper integrationMapper;

   @Inject
   LogicService logicService;

   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceConsumer.class);

   @Incoming("operativt-uppgiftslager-responses")
   public void onReply(ExempelRtfResponsePayload reply)
   {
      LOGGER.info("OUL Reply mottaget med ID: " + reply.getProcessId());
      var response = integrationMapper.fromExternalApi(reply);
      logicService.responseForManuelTask(response);
   }
}
