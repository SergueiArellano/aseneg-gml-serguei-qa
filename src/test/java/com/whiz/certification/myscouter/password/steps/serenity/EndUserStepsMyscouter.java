package com.whiz.certification.myscouter.password.steps.serenity;

import com.whiz.certification.myscouter.password.dto.DtoMyscouter;
import com.whiz.certification.myscouter.password.helpers.Constant;
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
