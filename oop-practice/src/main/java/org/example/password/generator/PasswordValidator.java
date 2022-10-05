package org.example.password.generator;

public class PasswordValidator {

    public static final String WRONG_PASSWORD_EXCEPTION_MESSAGE = "비밀번호는 8자 이상이어야 한다";

    public static void validate(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_EXCEPTION_MESSAGE);
        }
    }
}
