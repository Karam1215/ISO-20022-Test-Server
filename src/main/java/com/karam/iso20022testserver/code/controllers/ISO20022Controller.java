package com.karam.iso20022testserver.code.controllers;

import com.karam.iso20022testserver.code.models.ISO20022Message;
import com.karam.iso20022testserver.code.services.ISO20022Handler;
import com.karam.iso20022testserver.code.services.XMLValidator;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.IOException;

@RestController
@RequestMapping("/iso20022")
public class ISO20022Controller {

    private static final Logger logger = LoggerFactory.getLogger(ISO20022Controller.class);

    @PostMapping(value = "/validate-iso20022", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> processMessage(@RequestBody String xmlMessage) {
        try {
            XMLValidator.validateXML(xmlMessage);

            ISO20022Message message = ISO20022Handler.parseXML(xmlMessage);

            logger.info("Received Message: {}", message);

            ISO20022Message response = createAcknowledgment(message);

            String responseXml = ISO20022Handler.generateXML(response);

            return ResponseEntity.ok()
                    .header("Status", "Accepted")
                    .body(responseXml);

        } catch (IOException | SAXException e) {
            logger.error("XML Validation or Parsing Error", e);
            return ResponseEntity.badRequest()
                    .header("Status", "Not Acceptable")
                    .body("<Error>Invalid XML Format</Error>");
        } catch (JAXBException e) {
            logger.error("XML Processing Error", e);
            return ResponseEntity.status(500)
                    .header("Status", "Internal Server Error")
                    .body("<Error>Unable to Process XML</Error>");
        }
    }

    private ISO20022Message createAcknowledgment(ISO20022Message receivedMessage) {
        ISO20022Message response = new ISO20022Message();

        ISO20022Message.AccountOpeningRequest ackRequest = new ISO20022Message.AccountOpeningRequest();

        if (receivedMessage.getAcctOpngReq() != null) {
            ISO20022Message.AccountOpeningRequest receivedRequest = receivedMessage.getAcctOpngReq();

            if (receivedRequest.getMsgId() != null) {
                ackRequest.setMsgId(receivedRequest.getMsgId());
            }

            if (receivedRequest.getCreationDateTime() != null) {
                ackRequest.setCreationDateTime(receivedRequest.getCreationDateTime());
            }

            if (receivedRequest.getInitiatingParty() != null) {
                ISO20022Message.InitiatingParty receivedInitiatingParty = receivedRequest.getInitiatingParty();
                ISO20022Message.InitiatingParty ackInitiatingParty = new ISO20022Message.InitiatingParty();

                ackInitiatingParty.setName(receivedInitiatingParty.getName());
                ackRequest.setInitiatingParty(ackInitiatingParty);
            }

            if (receivedRequest.getSupplementaryData() != null) {
                ISO20022Message.SupplementaryData receivedSupplementaryData = receivedRequest.getSupplementaryData();
                ISO20022Message.SupplementaryData ackSupplementaryData = new ISO20022Message.SupplementaryData();

                ackSupplementaryData.setPlaceAndName(receivedSupplementaryData.getPlaceAndName());
                ackRequest.setSupplementaryData(ackSupplementaryData);
            }
        }
        response.setAcctOpngReq(ackRequest);

        return response;
    }
}
