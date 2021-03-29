package com.example.demo.dto;

public class FreshVocabResponse {
    private String message;

    public FreshVocabResponse() {
    }

    public FreshVocabResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
