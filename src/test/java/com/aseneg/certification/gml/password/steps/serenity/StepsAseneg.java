package com.aseneg.certification.gml.password.steps.serenity;

import com.aseneg.certification.gml.password.dto.DTOAseneg;
import com.aseneg.certification.gml.password.helpers.TemplateAseneg;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class StepsAseneg {
    private static final String URL_BASE = "http://ovc.catastro.meh.es";

    private TemplateAseneg templateAseneg = new TemplateAseneg();

    @Step("Ejecuta servicio Soap para consulta de Municipios Sistema Tiempo Metrologico")
    public void ejecutaServicioSoap(DTOAseneg aseneg) {
        String resource="/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx";

        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "text/xml;charset=UTF-8");
        headers.put("SOAPAction", "http://tempuri.org/OVCServWeb/OVCCallejero/ConsultaMunicipio");

        Actor serguei=Actor.named("Serguei");

        serguei.can(CallAnApi.at(URL_BASE));

        serguei.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.headers(headers)
                                        .body(templateAseneg.getXMLConsultaMunicipio(aseneg))
                        )
        );

        System.out.println(LastResponse.received().answeredBy(serguei)
                .asString());

    }
}
