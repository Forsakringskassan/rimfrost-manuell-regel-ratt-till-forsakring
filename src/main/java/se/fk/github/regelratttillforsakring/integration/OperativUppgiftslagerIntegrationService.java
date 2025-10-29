package se.fk.github.regelratttillforsakring.integration;

//import integration.dto.IntegrationFolkbokfordRequest;
//import integration.dto.IntegrationFolkbokfordResponse;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import se.fk.rimfrost.api.folkbokforing.jaxrsspec.controllers.generatedsource.FolkbokforingControllerApi;

@ApplicationScoped
public class OperativUppgiftslagerIntegrationService
{

   @ConfigProperty(name = "folkbokford.api.base-url")
   String folkbokfordBaseUrl;

   @Inject
   IntegrationMapper integrationMapper;

   private static final Logger LOGGER = LoggerFactory.getLogger(OperativUppgiftslagerIntegrationService.class);

   //   private FolkbokforingControllerApi folkbokfordClient;

   //   @PostConstruct
   //   void init()
   //   {
   //      //      this.folkbokfordClient = new JaxrsClientFactory()
   //      //            .create(JaxrsClientOptionsBuilders.createClient(folkbokfordBaseUrl, FolkbokforingControllerApi.class)
   //      //                  .build());
   //   }
   //
   //   public IntegrationFolkbokfordResponse pakallaManuellUppgift(IntegrationFolkbokfordRequest externalRequest)
   //   {
   //
   //      //      var request = integrationMapper.toExternalApi(externalRequest);
   //      //      var response = folkbokfordClient.folkbokforingPersnrGet(request);
   //      //      return integrationMapper.fromExternalApi(response);
   //   }
}
