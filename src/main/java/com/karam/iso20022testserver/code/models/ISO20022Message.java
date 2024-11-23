package com.karam.iso20022testserver.code.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02", propOrder = {"acctOpngReq"})
public class ISO20022Message {

    @XmlElement(name = "AcctOpngReq")
    private AccountOpeningRequest acctOpngReq;

    public AccountOpeningRequest getAcctOpngReq() {
        return acctOpngReq;
    }

    public void setAcctOpngReq(AccountOpeningRequest acctOpngReq) {
        this.acctOpngReq = acctOpngReq;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "AccountOpeningRequestType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"msgId", "creationDateTime", "initiatingParty", "account", "supplementaryData"})
    public static class AccountOpeningRequest {

        @XmlElement(name = "MsgId")
        private String msgId;

        @XmlElement(name = "CreDtTm")
        private String creationDateTime;

        @XmlElement(name = "InitgPty")
        private InitiatingParty initiatingParty;

        @XmlElement(name = "Acct")
        private Account account;

        @XmlElement(name = "SplmtryData")
        private SupplementaryData supplementaryData;

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getCreationDateTime() {
            return creationDateTime;
        }

        public void setCreationDateTime(String creationDateTime) {
            this.creationDateTime = creationDateTime;
        }

        public InitiatingParty getInitiatingParty() {
            return initiatingParty;
        }

        public void setInitiatingParty(InitiatingParty initiatingParty) {
            this.initiatingParty = initiatingParty;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public SupplementaryData getSupplementaryData() {
            return supplementaryData;
        }

        public void setSupplementaryData(SupplementaryData supplementaryData) {
            this.supplementaryData = supplementaryData;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "InitiatingPartyType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"name", "id"})
    public static class InitiatingParty {

        @XmlElement(name = "Nm")
        private String name;

        @XmlElement(name = "Id")
        private PartyIdentification id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PartyIdentification getId() {
            return id;
        }

        public void setId(PartyIdentification id) {
            this.id = id;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "PartyIdentificationType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"privateId"})
    public static class PartyIdentification {

        @XmlElement(name = "PrvtId")
        private PrivateIdentification privateId;

        public PrivateIdentification getPrivateId() {
            return privateId;
        }

        public void setPrivateId(PrivateIdentification privateId) {
            this.privateId = privateId;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "PrivateIdentificationType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"other"})
    public static class PrivateIdentification {

        @XmlElement(name = "Othr")
        private OtherIdentification other;

        public OtherIdentification getOther() {
            return other;
        }

        public void setOther(OtherIdentification other) {
            this.other = other;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "OtherIdentificationType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"id", "schemeName"})
    public static class OtherIdentification {

        @XmlElement(name = "Id")
        private String id;

        @XmlElement(name = "SchmeNm")
        private SchemeName schemeName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public SchemeName getSchemeName() {
            return schemeName;
        }

        public void setSchemeName(SchemeName schemeName) {
            this.schemeName = schemeName;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "SchemeNameType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"code"})
    public static class SchemeName {

        @XmlElement(name = "Cd")
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "AccountType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02")
    public static class Account {

        @XmlElement(name = "AcctTp")
        private AccountType accountType;

        @XmlElement(name = "Ccy")
        private String currency;

        @XmlElement(name = "IBAN")
        private String iban;  // IBAN for handling various international account formats

        public AccountType getAccountType() {
            return accountType;
        }

        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getIban() {
            return iban;
        }

        public void setIban(String iban) {
            this.iban = iban;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "AccountTypeDetails",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"proprietary"})
    public static class AccountType {

        @XmlElement(name = "Prtry")
        private String proprietary;

        public String getProprietary() {
            return proprietary;
        }

        public void setProprietary(String proprietary) {
            this.proprietary = proprietary;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "SupplementaryDataType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"placeAndName", "envelope"})
    public static class SupplementaryData {

        @XmlElement(name = "PlcAndNm")
        private String placeAndName;

        @XmlElement(name = "Envlp")
        private Envelope envelope;

        public String getPlaceAndName() {
            return placeAndName;
        }

        public void setPlaceAndName(String placeAndName) {
            this.placeAndName = placeAndName;
        }

        public Envelope getEnvelope() {
            return envelope;
        }

        public void setEnvelope(Envelope envelope) {
            this.envelope = envelope;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "EnvelopeType",
            namespace = "urn:iso:std:iso:20022:tech:xsd:acmt.001.001.02",
            propOrder = {"any"})
    public static class Envelope {

        @XmlElement(name = "Any")
        private String any;

        public String getAny() {
            return any;
        }

        public void setAny(String any) {
            this.any = any;
        }
    }
}
