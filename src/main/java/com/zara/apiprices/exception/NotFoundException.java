package com.zara.apiprices.exception;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found Exception (204)";

    public NotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}
