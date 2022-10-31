package com.aseneg.certification.gml.password.steps;

import com.aseneg.certification.gml.password.dto.DTOAseneg;
import com.aseneg.certification.gml.password.steps.serenity.StepsAseneg;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;

public class DefinitionStepsAseneg {
    private DTOAseneg aseneg = new DTOAseneg();
    private Actor serguei;

    @Steps
    private StepsAseneg asenegSteps;

    @Dado("que {} indica la provincia {} y el municipio {}")
    public void queElUsuarioIndicaLaProvinciaProvinciaYElMunicipioMunicipio(String actor, String provincia, String municipio) {
        aseneg.setProvincia(provincia);
        aseneg.setMunicipio(municipio);
        serguei = Actor.named(actor);
        asenegSteps.otorgarHabilidadesAlActor(serguei);
    }

    @Cuando("Serguei ejecuta el servicio soap para la consulta de municipios en el sistema Tiempo Metrologico")
    public void elUsuarioEjecutaElServicioSoapParaLaConsultaDeMunicipiosEnElSistemaTiempoMetrologico() {
        asenegSteps.ejecutaServicioSoap(aseneg, serguei);
    }

    @Entonces("Serguei puede ver que el servicio soap se ejecuta de manera correcta")
    public void elUsuarioPuedeVerQueElServicioSoapSeEjecutaDeManeraCorrecta() {
        asenegSteps.verificarResponse(serguei);
        asenegSteps.verificarResponseMunicipio(serguei, aseneg);
    }
}
