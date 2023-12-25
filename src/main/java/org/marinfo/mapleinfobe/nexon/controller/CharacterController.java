package org.marinfo.mapleinfobe.nexon.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.nexon.service.CharacterService;
import org.marinfo.mapleinfobe.nexon.dto.CharacterBasic;
import org.marinfo.mapleinfobe.nexon.dto.CharacterStat;
import org.marinfo.mapleinfobe.nexon.dto.CharacterVmatrix;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/basic")
    public ResponseEntity<CharacterBasic> getCharacterBasic(@RequestParam @NotBlank String characterName) {
        var result = characterService.getCharacterBasic(characterName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/stat")
    public ResponseEntity<CharacterStat> getCharacterStat(@RequestParam @NotBlank String characterName) {
        var result = characterService.getCharacterStat(characterName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/vmatrix")
    public ResponseEntity<CharacterVmatrix> getCharacterVmatrix(@RequestParam @NotBlank String characterName) {
        var result = characterService.getCharacterVmatrix(characterName);
        return ResponseEntity.ok(result);
    }

}
