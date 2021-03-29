package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.VocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VocabController {

    @Autowired
    VocabService vocabService;

    @GetMapping
    @RequestMapping("/old")
    public ResponseEntity<VocabResponse> getRandomVocab() {
        return getRandomVocabPrivate();
    }

    @GetMapping
    @RequestMapping("/new")
    public ResponseEntity<VocabResponse> learnNewRandomVocab() {
        return vocabService.learnNewRandomVocab()
                .map(VocabResponse::new)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("No new entries!"));
    }

    @PostMapping
    @RequestMapping("/did-guess")
    public ResponseEntity<VocabResponse> setDidGuess(@RequestBody DidGuessRequest didGuessRequest) {
        vocabService.setDidGuess(didGuessRequest.getId(), didGuessRequest.didGuess());
        return getRandomVocabPrivate();
    }

    @PostMapping
    @RequestMapping("/fresh")
    public ResponseEntity<FreshVocabResponse> addNewVocab(@RequestBody FreshVocabRequest freshVocabRequest) {
        vocabService.addNewVocab(freshVocabRequest.getPolish(), freshVocabRequest.getEnglish(), freshVocabRequest.isStartNow());
        return ResponseEntity.ok(
            new FreshVocabResponse("New " + (freshVocabRequest.isStartNow() ? "used" : "unused") + " entry added!")
        );
    }

    @PostMapping
    @RequestMapping("/deactivate")
    public ResponseEntity<DeactivateVocabResponse> deactivateVocab(@RequestBody DeactivateVocabRequest deactivateVocabRequest) {
        vocabService.deactivateVocab(deactivateVocabRequest.getId());
        return ResponseEntity.ok(
            new DeactivateVocabResponse("Vocab " + deactivateVocabRequest.getId() + " deactivated!")
        );
    }

    private ResponseEntity<VocabResponse> getRandomVocabPrivate() {
        return vocabService.getRandomVocabInUse()
                .map(VocabResponse::new)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("No entries in use!"));
    }

}
