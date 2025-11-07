package se.fk.github.manuellregelratttillforsakring.integration;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.BeslutUtfall;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessageData;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessagePayload;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessagePayload;
import se.fk.rimfrost.VahRtfManuellRequestMessagePayload;
import se.fk.rimfrost.VahRtfManuellResponseMessageData;
import se.fk.rimfrost.VahRtfManuellResponseMessagePayload;

@ApplicationScoped
public class IntegrationMapper
{
   public OperativtUppgiftslagerRequestMessagePayload toOperativtUppgiftsLagerRequest(
         VahRtfManuellRequestMessagePayload rtfRequest)
   {
      var oulRequestPayload = new OperativtUppgiftslagerRequestMessagePayload();
      var oulRequestData = new OperativtUppgiftslagerRequestMessageData();
      oulRequestData.setProcessId(rtfRequest.getData().getProcessId());
      oulRequestData.setPersonNummer(rtfRequest.getData().getPersonNummer());
      oulRequestData.setUppgiftsBeskrivning("Kolla om personen har rätt till försäkring");

      oulRequestPayload.setId(rtfRequest.getId());
      oulRequestPayload.setSpecversion(rtfRequest.getSpecversion());
      oulRequestPayload.setSource(rtfRequest.getSource());
      oulRequestPayload.setType("operativt-uppgiftslager-requests");
      oulRequestPayload.setKogitorootprocid(rtfRequest.getKogitorootprocid());
      oulRequestPayload.setKogitorootprociid(rtfRequest.getKogitorootprociid());
      oulRequestPayload.setKogitoparentprociid(rtfRequest.getKogitoparentprociid());
      oulRequestPayload.setKogitoprocid(rtfRequest.getKogitoprocid());
      oulRequestPayload.setKogitoprocinstanceid(rtfRequest.getKogitoprocinstanceid());
      oulRequestPayload.setKogitoprocrefid(rtfRequest.getKogitoprocinstanceid());
      oulRequestPayload.setKogitoprocist(rtfRequest.getKogitoprocist());
      oulRequestPayload.setKogitoproctype(rtfRequest.getKogitoproctype());
      oulRequestPayload.setKogitoprocversion(rtfRequest.getKogitoprocversion());
      oulRequestPayload.setData(oulRequestData);
      return oulRequestPayload;
   }

   public VahRtfManuellResponseMessagePayload toRtfResponse(OperativtUppgiftslagerResponseMessagePayload oulResponse)
   {
      VahRtfManuellResponseMessageData data = new VahRtfManuellResponseMessageData();
      data.setProcessId(oulResponse.getData().getProcessId());
      data.setPersonNummer(oulResponse.getData().getPersonnummer());
      data.setRattTillForsakring(oulResponse.getData().getBeslutUtfall() == BeslutUtfall.BEVILJAT);

      VahRtfManuellResponseMessagePayload response = new VahRtfManuellResponseMessagePayload();
      response.setId(oulResponse.getId());
      response.setSpecversion(oulResponse.getSpecversion());
      response.setSource(oulResponse.getSource());
      response.setType("vah-rtf-manuell-responses");
      response.setKogitorootprocid(oulResponse.getKogitorootprocid());
      response.setKogitorootprociid(oulResponse.getKogitorootprociid());
      response.setKogitoparentprociid(oulResponse.getKogitoparentprociid());
      response.setKogitoprocid(oulResponse.getKogitoprocid());
      response.setKogitoprocinstanceid(oulResponse.getKogitoprocinstanceid());
      response.setKogitoprocrefid(oulResponse.getKogitoprocinstanceid());
      response.setKogitoprocist(oulResponse.getKogitoprocist());
      response.setKogitoproctype(oulResponse.getKogitoproctype());
      response.setKogitoprocversion(oulResponse.getKogitoprocversion());
      response.setData(data);

      return response;
   }
}
