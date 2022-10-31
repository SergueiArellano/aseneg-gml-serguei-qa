package com.aseneg.certification.gml.password.helpers;

import com.aseneg.certification.gml.password.dto.DTOAseneg;

public class TemplateAseneg {
    public String getXMLConsultaMunicipio(DTOAseneg aseneg) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cat=\"http://www.catastro.meh.es/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <cat:Provincia>" + aseneg.getProvincia() + "</cat:Provincia>\n" +
                "      <cat:Municipio>" + aseneg.getMunicipio() + "</cat:Municipio>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
