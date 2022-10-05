package org.example.password.generator;

import org.example.password.generator.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "123";
    }
}
