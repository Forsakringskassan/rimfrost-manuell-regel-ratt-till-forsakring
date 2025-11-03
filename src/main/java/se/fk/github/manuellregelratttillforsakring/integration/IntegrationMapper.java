package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.manuellregelratttillforsakring.integration.dto.*;

@ApplicationScoped
public class IntegrationMapper
{
   
   public OulRequest toOperativtUppgiftsLagerRequest(VahRtfManuellRequest rtfRequest)
   {
      return ImmutableOulRequest.builder()
         .processId(rtfRequest.processId())
         .personNummer(rtfRequest.personnummer())
         .uppgift("Kolla om personen har rätt till försäkring")
         .build();
   }
   
   public CloudEvent<VahRtfManuellResponse> toRtfResponse(OulResponse oulResponse,
         CloudEvent<VahRtfManuellRequest> request)
   {
      return ImmutableCloudEvent.<VahRtfManuellResponse> builder()
            .id(request.id())
            .source(request.source())
            .type("vah-rtf-manuell-responses")
            .kogitorootprocid(request.kogitorootprocid())
            .kogitorootprociid(request.kogitorootprociid())
            .kogitoparentprociid(request.kogitoparentprociid())
            .kogitoprocid(request.kogitoprocid())
            .kogitoprocinstanceid(request.kogitoprocinstanceid())
            .kogitoprocrefid(request.kogitoprocinstanceid())
            .kogitoprocist(request.kogitoprocist())
            .kogitoproctype(request.kogitoproctype())
            .kogitoprocversion(request.kogitoprocversion())
            .data(ImmutableVahRtfManuellResponse.builder()
               .processId(oulResponse.processId())
               .personnummer(oulResponse.personnummer())
               .resultat(oulResponse.resultat())
               .build())
            .build();
   }
}
