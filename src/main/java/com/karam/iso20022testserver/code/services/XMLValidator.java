package com.karam.iso20022testserver.code.services;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import com.karam.iso20022testserver.code.exeptions.XmlValidationException;
import org.xml.sax.SAXException;

public class XMLValidator {

    private static final String SCHEMA_FILE = "/home/karam/ISO20022-Test-Server/src/main/resources/schemas/iso20022Request.xsd";

    public static void validateXML(String xml) throws SAXException, IOException {
      try {
          SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
          Schema schema = factory.newSchema(new File(SCHEMA_FILE));
          Validator validator = schema.newValidator();
          validator.validate(new StreamSource(new StringReader(xml)));
      } catch (SAXException e) {
        throw new XmlValidationException("XML is not valid according to the schema: " + e.getMessage());
    } catch (Exception e) {
        throw new XmlValidationException("Unexpected error during XML validation: " + e.getMessage());
        }
    }
}
