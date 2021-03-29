package com.example.demo.dto;

public class DidGuessRequest {
    private long id;
    private boolean didGuess;

    public DidGuessRequest() {
    }

    public DidGuessRequest(long id, boolean didGuess) {
        this.id = id;
        this.didGuess = didGuess;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean didGuess() {
        return didGuess;
    }

    public void setDidGuess(boolean didGuess) {
        this.didGuess = didGuess;
    }
}
