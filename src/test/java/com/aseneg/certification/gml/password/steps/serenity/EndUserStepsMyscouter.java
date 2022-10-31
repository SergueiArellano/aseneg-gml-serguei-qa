package com.aseneg.certification.gml.password.steps.serenity;

import com.aseneg.certification.gml.password.dto.DtoMyscouter;
import com.aseneg.certification.gml.password.helpers.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EndUserStepsMyscouter {

    @Step("Servicio Rest Post")
    public void runRecoveryPasswordService(DtoMyscouter dto){
        SerenityRest.given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\":\""+ dto.getEmail()+"\"\n" +
                        "}")
                .post(Constant.ENDPOINT_RECOVERY_PASSWORD);
    }
}
