package com.karam.iso20022testserver.code.services;

import com.karam.iso20022testserver.code.exeptions.InvalidIbanException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class IbanValidationService {

    private static final Pattern IBAN_PATTERN = Pattern.compile("^[A-Z]{2}\\d{2}[A-Z0-9]{4,30}$");

    public void validateIban(String iban) {
        if (!IBAN_PATTERN.matcher(iban).matches()) {
            throw new InvalidIbanException("Invalid IBAN format: " + iban);
        }
    }
}
