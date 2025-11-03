package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.fk.github.manuellregelratttillforsakring.integration.dto.CloudEvent;
import se.fk.github.manuellregelratttillforsakring.integration.dto.OulRequest;
import se.fk.github.manuellregelratttillforsakring.integration.dto.VahRtfManuellResponse;

@ApplicationScoped
public class IntegrationServiceProducer
{
   private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceProducer.class);

   @Inject
   IntegrationMapper integrationMapper;

   @Outgoing("vah-rtf-manuell-responses")
   public CloudEvent<VahRtfManuellResponse> sendRtfResponse(CloudEvent<VahRtfManuellResponse> rtfResponse)
   {
      LOGGER.info("Sent RtfResponse with ID: " + rtfResponse.data().processId());
      return rtfResponse;
   }

   @Outgoing("operativt-uppgiftslager-requests")
   public OulRequest sendOulRequest(OulRequest oulRequest)
   {
      LOGGER.info("Sent OulRequest with ID: " + oulRequest.processId());
      return oulRequest;
   }
}