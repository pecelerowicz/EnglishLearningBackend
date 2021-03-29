package com.example.demo.service;

import com.example.demo.Entry;
import com.example.demo.VocabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VocabServiceImpl implements VocabService {

    @Autowired
    private VocabRepository vocabRepository;

    @Override
    public Optional<Entry> getRandomVocabInUse() {
        return randomElementMaybe(vocabRepository.findAllInUse());
    }

    @Override
    public Optional<Entry> learnNewRandomVocab() {
        return randomElementMaybe(vocabRepository.findAllNew());
    }

    @Override
    @Transactional
    public void setDidGuess(long id, boolean didGuess) {
        Entry entry = vocabRepository.findById(id).orElseThrow(() -> new RuntimeException("No entry with id: " + id + "!"));
        if(didGuess) {
            entry.setSucceeded(entry.getSucceeded() + 1);
        } else {
            entry.setFailed(entry.getFailed() + 1);
        }
    }

    private Optional<Entry> randomElementMaybe(List<Entry> entries) {
        if(entries.size() != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, entries.size());
            return Optional.of(entries.get(randomNum));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void addNewVocab(String polish, String english, boolean startNow) {
        if(startNow) {
            vocabRepository.save(new Entry(polish, english, 0, 1, true));
        } else {
            vocabRepository.save(new Entry(polish, english, 0, 0, true));
        }
    }

    @Override
    @Transactional
    public void deactivateVocab(long id) {
        vocabRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entry with id: " + id + "!"))
                .setActive(false);
    }
}








