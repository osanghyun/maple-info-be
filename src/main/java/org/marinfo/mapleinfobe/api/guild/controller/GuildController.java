package org.marinfo.mapleinfobe.api.guild.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.api.guild.service.GuildService;
import org.marinfo.mapleinfobe.api.guild.vo.GuildBasic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guild")
@RequiredArgsConstructor
public class GuildController {
    private final GuildService guildService;

    @GetMapping("/basic")
    public ResponseEntity<GuildBasic> getGuildBasic(@RequestParam @NotBlank String guildName,
                                                    @RequestParam @NotBlank String worldName) {
        var result = guildService.getGuildBasic(guildName, worldName);
        return ResponseEntity.ok(result);
    }
}
