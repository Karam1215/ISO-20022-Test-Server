<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ISO 20022 Test Server Project README">
    <title>ISO 20022 Test Server</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }
        header {
            background-color: #4caf50;
            color: white;
            padding: 20px;
            text-align: center;
        }
        header h1 {
            margin: 0;
            font-size: 2.5em;
        }
        header p {
            margin: 10px 0 0;
            font-size: 1.2em;
        }
        nav {
            background: #333;
            padding: 10px 0;
            text-align: center;
        }
        nav a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
        }
        nav a:hover {
            text-decoration: underline;
        }
        .container {
            padding: 20px;
            max-width: 900px;
            margin: auto;
        }
        .section {
            margin-bottom: 40px;
        }
        .section h2 {
            border-bottom: 3px solid #4caf50;
            padding-bottom: 10px;
            color: #4caf50;
        }
        .section p {
            margin: 15px 0;
        }
        .code-block {
            background: #e8e8e8;
            padding: 15px;
            border-radius: 5px;
            font-family: "Courier New", Courier, monospace;
            overflow-x: auto;
        }
        footer {
            text-align: center;
            background: #333;
            color: white;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>ISO 20022 Test Server</h1>
        <p>A lightweight server to validate XML against ISO 20022 schema</p>
    </header>
    <nav>
        <a href="#overview">Overview</a>
        <a href="#features">Features</a>
        <a href="#setup">Setup</a>
        <a href="#usage">Usage</a>
        <a href="#structure">Project Structure</a>
        <a href="#example">Test Example</a>
    </nav>
    <div class="container">
        <section id="overview" class="section">
            <h2>Overview</h2>
            <p>
                The <strong>ISO 20022 Test Server</strong> is a project built to validate and process XML messages 
                against a predefined ISO 20022 schema. It includes validation services, error handling, 
                and business rule checks such as IBAN verification.
            </p>
        </section>
        <section id="features" class="section">
            <h2>Features</h2>
            <ul>
                <li>Validate XML messages against ISO 20022 schema</li>
                <li>Custom exception handling for detailed error reporting</li>
                <li>IBAN validation with tailored business rules</li>
                <li>Global error handling for unexpected scenarios</li>
            </ul>
        </section>
        <section id="setup" class="section">
            <h2>Setup</h2>
            <p>This project uses <strong>OpenJDK 22</strong> as the default SDK. Ensure it is installed and set up on your machine.</p>
            <p>Follow these steps to set up the project:</p>
            <ol>
                <li>Clone the repository:</li>
                <div class="code-block">git clone https://github.com/your-repo-name.git</div>
                <li>Navigate to the project directory:</li>
                <div class="code-block">cd ISO20022-Test-Server</div>
                <li>Build the project using Maven:</li>
                <div class="code-block">mvn clean install</div>
                <li>Run the application:</li>
                <div class="code-block">mvn spring-boot:run</div>
            </ol>
        </section>
        <section id="usage" class="section">
            <h2>Usage</h2>
            <p>
                The server processes incoming XML messages and validates them against the schema. Example usage:
            </p>
            <ol>
                <li>Send an XML request to the server using a POST request to the endpoint:</li>
                <div class="code-block">POST /api/validate</div>
                <li>The server returns:</li>
                <ul>
                    <li><strong>200 OK</strong> if the XML is valid</li>
                    <li><strong>400 Bad Request</strong> with error details if validation fails</li>
                </ul>
            </ol>
        </section>
        <section id="structure" class="section">
            <h2>Project Structure</h2>
            <p>The project follows a layered architecture:</p>
            <ul>
                <li><strong>Controllers:</strong> Handle incoming HTTP requests</li>
                <li><strong>Services:</strong> Core business logic such as XML and IBAN validation</li>
                <li><strong>Models:</strong> Define the structure of the ISO 20022 message</li>
                <li><strong>Exceptions:</strong> Custom exception handling</li>
            </ul>
        </section>
        <section id="example" class="section">
            <h2>Test Example</h2>
            <p>Use the following XML as an example for testing:</p>
            <div class="code-block">
                &lt;?xml version="1.0" encoding="UTF-8"?&gt;<br>
                &lt;Document xmlns="urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02"&gt;<br>
                &nbsp;&nbsp;&lt;AcctOpngReq&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;MsgId&gt;MSG12345&lt;/MsgId&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;CreDtTm&gt;2024-11-23T12:30:00Z&lt;/CreDtTm&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;InitgPty&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Nm&gt;karam&lt;/Nm&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Id&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;PrvtId&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Othr&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Id&gt;1234567890&lt;/Id&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;SchmeNm&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Cd&gt;SSN&lt;/Cd&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/SchmeNm&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/Othr&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/PrvtId&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/Id&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;/InitgPty&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;Acct&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;AcctTp&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Prtry&gt;Saving&lt;/Prtry&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/AcctTp&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Ccy&gt;RUB&lt;/Ccy&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;IBAN&gt;RU12345678901234567890123456&lt;/IBAN&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;/Acct&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;SplmtryData&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;PlcAndNm&gt;Moscow&lt;/PlcAndNm&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Envlp&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;Any&gt;&lt;/Any&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/Envlp&gt;<br>
                &nbsp;&nbsp;&nbsp;&nbsp;&lt;/SplmtryData&gt;<br>
                &nbsp;&nbsp;&lt;/AcctOpngReq&gt;<br>
                &lt;/Document&gt;
            </div>
        </section>
    </div>
    <footer>
        <p>&copy; 2024 ISO 20022 Test Server. All rights reserved.</p>
    </footer>
</body>
</html>
