package com.example.project.service.validity;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordValidator {

    public boolean isValidPassword(String password){
        if(password.length() >=8){
            Pattern lowLetter = Pattern.compile("[a-z]");
            Pattern upLetter = Pattern.compile("[A-Z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern symbol = Pattern.compile("[!\"#$%&'()*+,-./:;<=>?@\\^_`{|}~]");
            Matcher hasLowLetter = lowLetter.matcher(password);
            Matcher hasUpLetter = upLetter.matcher(password);
            Matcher  hasDigit = digit.matcher(password);
            Matcher hasSymbol = symbol.matcher(password);

            return hasLowLetter.find() && hasUpLetter.find() && hasDigit.find() && hasSymbol.find();
        }
        return false;
    }
}