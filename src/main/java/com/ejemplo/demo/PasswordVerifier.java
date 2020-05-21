package com.ejemplo.demo;

public class PasswordVerifier {

    public void verify(String password) {
        String errors = getErrors(password);
        if (!errors.equals("")) {
            throw new RuntimeException(errors);
        }
    }

    private String getErrors(String password) {

        String errors = "";

        // OR
        if (password == null || password.trim().isEmpty()) {
            errors = "La contraseña no debe de ser nula o vacia ";
            return errors;
        }

        if (password.length() < 9) {
            errors += "La contraseña debe ser mayor a 8 caracteres ";
        }

        char[] charsPassword = password.toCharArray();

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;

        for (char character : charsPassword) {
            if (Character.isUpperCase(character)) {
                isUpperCase = true;
            }

            if (Character.isLowerCase(character)) {
                isLowerCase = true;
            }

            if (Character.isDigit(character)) {
                isDigit = true;
            }
        }

        if (!isUpperCase) {
            errors += "La contraseña debe tener al menos una letra en mayuscula ";
        }

        if (!isLowerCase) {
            errors += "La contraseña debe tener al menos una letra en miniuscula ";
        }

        if (!isDigit) {
            errors += "La contraseña debe tener al menos un numero ";
        }

        return errors;
    }
}
