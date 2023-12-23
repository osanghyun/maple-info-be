package org.marinfo.mapleinfobe.api.character.controller;

import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.api.character.dto.CharacterOcidRequest;
import org.marinfo.mapleinfobe.api.character.dto.CharacterOcidResponse;
import org.marinfo.mapleinfobe.api.character.service.CharacterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/ocid")
    public CharacterOcidResponse getCharacterOcid(@ModelAttribute CharacterOcidRequest request) {
        return characterService.getCharacterOcid(request);
    }

}
