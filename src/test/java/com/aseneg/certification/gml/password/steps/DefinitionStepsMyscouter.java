package com.aseneg.certification.gml.password.steps;

import com.aseneg.certification.gml.password.dto.DtoMyscouter;
import com.aseneg.certification.gml.password.helpers.Constant;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import com.aseneg.certification.gml.password.steps.serenity.EndUserStepsMyscouter;
import org.apache.http.HttpStatus;

import java.util.logging.Logger;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DefinitionStepsMyscouter {

    @Steps
    EndUserStepsMyscouter endUserStepsMyscouter;

    DtoMyscouter dtoMyscouter = new DtoMyscouter();

    @Dado("^que (.*) quiere recuperar la contraseña que olvidó$")
    public void recoveryPasswordYouForgot(String name) {
        Logger.getLogger("Inicio prueba ***********************");
    }

    @Cuando("^(.*) ejecuta el servicio rest para recuperar contraseña indicando email (.*) registrado en Myscouter$")
    public void runRestServiceToRecoverPassword(String name, String email) {
        dtoMyscouter.setEmail(email);
        endUserStepsMyscouter.runRecoveryPasswordService(dtoMyscouter);
    }

    @Entonces("^(.*) puede ver que el servicio rest se ejecuta de manera correcta$")
    public void restServiceRunsOk(String name) {
        restAssuredThat(response -> response.statusCode(HttpStatus.SC_OK));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("message", equalTo(Constant.MESSAGE_EMAIL_ENVIADO)));
        Logger.getLogger("Fin prueba ***********************");
    }

    @Entonces("^(.*) puede ver que el servicio rest no se ejecuta de manera correcta porque el email no está registrado")
    public void namePuedeVerQueElServicioRestNoSeEjecutaDeManeraCorrectaPorqueElEmailNoEstáRegistrado(String name) {
        restAssuredThat(response -> response.statusCode(HttpStatus.SC_BAD_REQUEST));
        restAssuredThat(response -> response.body("error", notNullValue()));
        Logger.getLogger("Fin prueba ***********************");
    }
}
