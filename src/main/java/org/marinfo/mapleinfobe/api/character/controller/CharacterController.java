package org.marinfo.mapleinfobe.api.character.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.api.character.service.CharacterService;
import org.marinfo.mapleinfobe.api.character.vo.CharacterBasic;
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

}
