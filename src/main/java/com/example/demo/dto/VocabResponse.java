package com.example.demo.dto;

import com.example.demo.Entry;

public class VocabResponse {
    private Long id;
    private String polish;
    private String english;
    private int failed;
    private int succeeded;

    public VocabResponse() {
    }

    public VocabResponse(Entry entry) {
        this.id = entry.getId();
        this.polish = entry.getPolish();
        this.english = entry.getEnglish();
        this.failed = entry.getFailed();
        this.succeeded = entry.getSucceeded();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getSucceeded() {
        return succeeded;
    }

    public void setSucceeded(int succeeded) {
        this.succeeded = succeeded;
    }
}
