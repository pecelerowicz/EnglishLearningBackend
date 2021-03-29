package com.example.demo.dto;

public class FreshVocabRequest {
    private String polish;
    private String english;
    private boolean startNow;

    public FreshVocabRequest() {
    }

    public FreshVocabRequest(String polish, String english, boolean startNow) {
        this.polish = polish;
        this.english = english;
        this.startNow = startNow;
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

    public boolean isStartNow() {
        return startNow;
    }

    public void setStartNow(boolean startNow) {
        this.startNow = startNow;
    }
}
