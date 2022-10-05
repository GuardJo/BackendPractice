package org.example.password.generator;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements org.example.password.generator.PasswordGenerator {
    public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
    public static final String ERROR_CODE = "ERRONEOUS_SPECTIAL_CHARS";

    public String generatePassword() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }

            @Override
            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };

        CharacterRule specialRule = new CharacterRule(specialChars);
        specialRule.setNumberOfCharacters(2);

        // 0 ~ 12
        return passwordGenerator.generatePassword((int) (Math.random() * 13), specialRule, lowerCaseRule, upperCaseRule, digitRule);
    }
}
