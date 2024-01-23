package org.marinfo.mapleinfobe.nexon.service;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.entity.CharacterOcidEntity;
import org.marinfo.mapleinfobe.nexon.dto.Ocid;
import org.marinfo.mapleinfobe.nexon.dto.OguildId;
import org.marinfo.mapleinfobe.repository.CharacterOcidRepository;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NexonIdentifyService {

    private final CharacterOcidRepository characterOcidRepository;

    public String getOcid(@NotBlank String characterName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("character_name", characterName);

        // TODO: 임시 코드.
        Optional<CharacterOcidEntity> characterOcidEntity = characterOcidRepository.findByCharacterName(characterName);

        if (characterOcidEntity.isEmpty()) {
            Ocid result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.OCID, params);
            CharacterOcidEntity entity = CharacterOcidEntity.create(characterName, result.getOcid());
            characterOcidRepository.save(entity);

            return result.getOcid();
        }
        else {
            return characterOcidEntity.get().getOcid();
        }

    }

    public String getOguildId(@NotBlank String guildName, @NotBlank String worldName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("guild_name", guildName);
        params.set("world_name", worldName);
        OguildId result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.GUILD_ID, params);
        return result.getOguildId();
    }
}
