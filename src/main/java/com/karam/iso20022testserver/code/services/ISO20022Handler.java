package com.karam.iso20022testserver.code.services;


import com.karam.iso20022testserver.code.models.ISO20022Message;
import jakarta.xml.bind.*;

import java.io.StringReader;
import java.io.StringWriter;

public class ISO20022Handler {
    public static ISO20022Message parseXML(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ISO20022Message.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (ISO20022Message) unmarshaller.unmarshal(new StringReader(xml));
    }

    public static String generateXML(ISO20022Message message) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ISO20022Message.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(message, stringWriter);
        return stringWriter.toString();
    }
}
