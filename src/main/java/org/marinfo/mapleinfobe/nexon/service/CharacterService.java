package org.marinfo.mapleinfobe.nexon.service;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.nexon.search.NexonOcidSearch;
import org.marinfo.mapleinfobe.nexon.dto.CharacterBasic;
import org.marinfo.mapleinfobe.nexon.dto.Ocid;
import org.marinfo.mapleinfobe.nexon.dto.CharacterStat;
import org.marinfo.mapleinfobe.nexon.dto.CharacterVmatrix;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterService {

    public CharacterBasic getCharacterBasic(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_BASIC, makeLatestSearchParams(characterName));
    }

    public CharacterStat getCharacterStat(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_STAT, makeLatestSearchParams(characterName));
    }

    public CharacterVmatrix getCharacterVmatrix(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_VMATRIX, makeLatestSearchParams(characterName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String characterName) {
        var ocid = getCharacterOcid(characterName);
        var characterSearch = NexonOcidSearch.create(ocid);
        return characterSearch.toMultiValueMap();
    }

    private String getCharacterOcid(@NotBlank String characterName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("character_name", characterName);
        Ocid result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_OCID, params);
        return result.getOcid();
    }
}
