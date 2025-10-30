package se.fk.github.manuellregelratttillforsakring.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.manuellregelratttillforsakring.logic.dto.ImmutableLogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellResponse;
import se.fk.github.manuellregelratttillforsakring.presentation.dto.*;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellRequestPayload;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellResponsePayload;

import java.util.UUID;

@ApplicationScoped
public class PresentationMapper
{
   public LogicManuellRequest toLogic(PresentationVahRtfManuellRequest presentation)
   {
      return ImmutableLogicManuellRequest.builder()
            .processId(presentation.processId())
            .personnummer(presentation.personnummer())
            .build();
   }

   public PresentationVahRtfManuellResponse toPresentation(LogicManuellResponse logic)
   {
      return ImmutablePresentationVahRtfManuellResponse.builder()
            .processId(logic.processId())
            .personnummer(logic.personnummer())
            .rattTillForsakring(logic.rattTillForsakring())
            .build();
   }

   public PresentationVahRtfManuellRequest fromExternalApi(VahRtfManuellRequestPayload externalRequest)
   {
      return ImmutablePresentationVahRtfManuellRequest.builder()
            .processId(UUID.fromString(externalRequest.getProcessId()))
            .personnummer(externalRequest.getPersonNummer())
            .build();
   }

   public VahRtfManuellResponsePayload toExternalApi(PresentationVahRtfManuellResponse presentationResponse)
   {
      var responsePayload = new VahRtfManuellResponsePayload();
      responsePayload.setProcessId(presentationResponse.processId().toString());
      responsePayload.setPersonNummer(presentationResponse.personnummer());
      responsePayload.setRattTillForsakring(presentationResponse.rattTillForsakring());
      return responsePayload;
   }
}
