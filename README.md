<h1 align="center">
  <img src="https://readme-typing-svg.herokuapp.com/?font=Righteous&size=35&center=true&vCenter=true&width=500&height=70&duration=4000&lines=ISO20022-Test-Server👋;" />
</h1>

This project is a web service designed for validating and processing ISO 20022 messages, specifically focused on IBAN validation and XML validation. The service is built using Java with Spring Boot and aims to provide a robust platform for handling ISO 20022 messaging and validation tasks.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Conclusion](#conclusion)

## Project Overview

The ISO20022 Test Server project is designed to help validate and process ISO 20022 messages in XML format. This server provides essential features such as IBAN validation and XML structure validation using a pre-defined XML schema.

## Technologies Used

- **Backend**: Java with Spring Boot
- **XML Validation**: JAXB, XML Schema (XSD)
- **IBAN Validation**: Custom service for IBAN format validation
- **Testing Tools**: Postman for API testing
- **Java SDK**: OpenJDK 22

## Features

1. **IBAN Validation**: Validates IBAN numbers against a set of rules for correctness.
2. **XML Validation**: Validates incoming XML messages against an ISO 20022 XML schema.
3. **Error Handling**: Provides detailed error responses in case of invalid requests.

## Installation

### Prerequisites

- Java 22 or higher
- Maven
- Postman (for testing)

### Backend Setup

1. Clone the repository:
    ```sh
    git clone git@github.com:Karam1215/ISO20022-Test-Server.git
    cd ISO20022-Test-Server
    ```

2. Build the project using Maven:
    ```sh
    ./mvnw clean install
    ```

3. Run the backend service:
    ```sh
    ./mvnw spring-boot:run
    ```

### Testing with Postman

1. Import the Postman collection file (included in the project) to start testing the API endpoints.
2. Test the IBAN validation and XML validation by sending the appropriate requests.

## Usage

1. Once the backend is running, you can interact with the service via the exposed API.
2. Example POST request to validate an ISO 20022 message:

    **URL**: `http://localhost:8080/api/validate-iso20022`

    **Body (Example XML)**:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Document xmlns="urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02">
        <AcctOpngReq>
            <MsgId>MSG12345</MsgId>
            <CreDtTm>2024-11-23T12:30:00Z</CreDtTm>
            <InitgPty>
                <Nm>karam</Nm>
                <Id>
                    <PrvtId>
                        <Othr>
                            <Id>1234567890</Id>
                            <SchmeNm>
                                <Cd>SSN</Cd>
                            </SchmeNm>
                        </Othr>
                    </PrvtId>
                </Id>
            </InitgPty>
            <Acct>
                <AcctTp>
                    <Prtry>Saving</Prtry>
                </AcctTp>
                <Ccy>RUB</Ccy>
                <IBAN>RU12345678901234567890123456</IBAN>
            </Acct>
            <SplmtryData>
                <PlcAndNm>Moscow</PlcAndNm>
                <Envlp>
                    <Any></Any>
                </Envlp>
            </SplmtryData>
        </AcctOpngReq>
    </Document>
    ```

3. The response will indicate whether the IBAN and XML structure are valid.

## Conclusion

This project offers a straightforward solution for validating ISO 20022 messages and provides a foundation for extending the functionality to handle additional message types or validation rules. It demonstrates how to integrate XML schema validation with custom logic for domain-specific data validation, such as IBAN numbers.
