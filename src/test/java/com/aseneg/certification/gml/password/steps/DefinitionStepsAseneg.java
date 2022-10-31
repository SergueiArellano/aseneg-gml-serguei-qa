package com.aseneg.certification.gml.password.steps;

import com.aseneg.certification.gml.password.dto.DTOAseneg;
import com.aseneg.certification.gml.password.steps.serenity.StepsAseneg;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import java.util.logging.Logger;

public class DefinitionStepsAseneg {
    private DTOAseneg aseneg = new DTOAseneg();

    @Steps
    private StepsAseneg asenegSteps;

    @Dado("que el usuario indica la provincia y el municipio")
    public void queElUsuarioIndicaLaProvinciaProvinciaYElMunicipioMunicipio() {
        Logger.getLogger("Inicio prueba ***********************");
        aseneg.setProvincia("PONTEVEDRA");
        aseneg.setMunicipio("VIGO");
    }

    @Cuando("el usuario ejecuta el servicio soap para la consulta de municipios en el sistema Tiempo Metrologico")
    public void elUsuarioEjecutaElServicioSoapParaLaConsultaDeMunicipiosEnElSistemaTiempoMetrologico() {
        asenegSteps.ejecutaServicioSoap(aseneg);
        
    }

    @Entonces("el usuario puede ver que el servicio soap se ejecuta de manera correcta")
    public void elUsuarioPuedeVerQueElServicioSoapSeEjecutaDeManeraCorrecta() {
        Logger.getLogger("Fin prueba ***********************");
    }
}
