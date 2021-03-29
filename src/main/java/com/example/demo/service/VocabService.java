package com.example.demo.service;

import com.example.demo.Entry;

import java.util.Optional;

public interface VocabService {
    Optional<Entry> getRandomVocabInUse();
    Optional<Entry> learnNewRandomVocab();
    void setDidGuess(long id, boolean didGuess);
    void addNewVocab(String polish, String english, boolean startNow);
    void deactivateVocab(long id);
}
