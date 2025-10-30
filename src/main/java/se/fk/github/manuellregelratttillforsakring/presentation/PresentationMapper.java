package se.fk.github.manuellregelratttillforsakring.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.manuellregelratttillforsakring.logic.dto.ImmutableLogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellRequest;
import se.fk.github.manuellregelratttillforsakring.logic.dto.LogicManuellResponse;
import se.fk.github.manuellregelratttillforsakring.presentation.dto.*;
import se.fk.gradle.rimfrostvahregelrtfmanuellt.VahRtfManuellRequestPayload;

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

   public VahRtfManuellResponse toExternalApi(PresentationVahRtfManuellResponse presentationResponse)
   {
      return ImmutableVahRtfManuellResponse.builder()
            .processId(presentationResponse.processId())
            .personnummer(presentationResponse.personnummer())
            .rattTillForsakring(presentationResponse.rattTillForsakring())
            .build();
   }
}
