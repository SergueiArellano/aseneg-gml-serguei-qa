package com.aseneg.certification.gml.password.steps.serenity;

import com.aseneg.certification.gml.password.dto.DTOAseneg;
import com.aseneg.certification.gml.password.helpers.TemplateAseneg;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static com.aseneg.certification.gml.password.helpers.Constant.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepsAseneg {


    private TemplateAseneg templateAseneg = new TemplateAseneg();

    @Step("Otorgar Habilidad al actor de llamar un API")
    public void otorgarHabilidadesAlActor(Actor serguei) {
        serguei.can(
                CallAnApi.at(URL_BASE)
        );
    }

    @Step("Ejecuta servicio Soap para consulta de Municipios Sistema Tiempo Metrologico")
    public void ejecutaServicioSoap(DTOAseneg aseneg, Actor actor) {
        String resource="/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx";

        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "text/xml;charset=UTF-8");
        headers.put("SOAPAction", "http://tempuri.org/OVCServWeb/OVCCallejero/ConsultaMunicipio");

        actor.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.headers(headers)
                                        .body(templateAseneg.getXMLConsultaMunicipio(aseneg))
                        )
        );
    }

    @Step("Verificar statuCode")
    public void verificarResponse(Actor actor) {
        assertThat("StatusCode", LastResponse.received().answeredBy(actor).statusCode(), equalTo(SC_OK));
        assertThat("", LastResponse.received().answeredBy(actor).body().asString(), containsString("VIGO") );
    }

    @Step("Verificar nombre municipio ")
    public void verificarResponseMunicipio(Actor actor, DTOAseneg aseneg) {
        assertThat("", LastResponse.received().answeredBy(actor).body().asString(), containsString(aseneg.getMunicipio()) );
    }
}
