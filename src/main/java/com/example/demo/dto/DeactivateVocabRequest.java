package com.example.demo.dto;

public class DeactivateVocabRequest {
    private long id;

    public DeactivateVocabRequest() {
    }

    public DeactivateVocabRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
