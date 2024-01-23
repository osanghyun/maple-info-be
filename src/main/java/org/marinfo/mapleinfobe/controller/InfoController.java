package org.marinfo.mapleinfobe.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.service.InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/refresh")
    public ResponseEntity<Boolean> refreshCharacterInfo(@RequestParam @NotBlank String characterName) {
        var result = infoService.refreshCharacterInfo(characterName);
        return ResponseEntity.ok(result);
    }
}
