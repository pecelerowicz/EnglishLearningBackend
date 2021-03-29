package com.example.demo.dto;

public class DeactivateVocabResponse {
    private String message;

    public DeactivateVocabResponse() {
    }

    public DeactivateVocabResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
