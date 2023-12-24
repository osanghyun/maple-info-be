package org.marinfo.mapleinfobe.api.character.service;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.api.character.search.CharacterSearch;
import org.marinfo.mapleinfobe.api.character.vo.CharacterBasic;
import org.marinfo.mapleinfobe.api.character.vo.CharacterOcid;
import org.marinfo.mapleinfobe.constant.UriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterService {

    public CharacterBasic getCharacterBasic(String characterName) {
        var ocid = getCharacterOcid(characterName);
        var characterSearch = CharacterSearch.create(ocid);
        var params = characterSearch.toMultiValueMap();

        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, UriPath.CHARACTER_BASIC, params);
    }

    private String getCharacterOcid(@NotBlank String characterName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("character_name", characterName);
        CharacterOcid result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, UriPath.CHARACTER_OCID, params);
        return result.getOcid();
    }
}
