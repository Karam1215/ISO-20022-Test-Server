package com.karam.iso20022testserver.code.test;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {
    public static void main(String[] args) throws Exception {
        // Load the XML file and schema
        File xmlFile = new File("yourfile.xml");
        File xsdFile = new File("yourSchema.xsd");

        // Set up SchemaFactory and Validator
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(xsdFile);
        Validator validator = schema.newValidator();

        // Validate the XML file
        try {
            validator.validate(new StreamSource(xmlFile));
            System.out.println("XML is valid.");
        } catch (SAXException e) {
            System.err.println("XML is not valid: " + e.getMessage());
        }
    }
}
