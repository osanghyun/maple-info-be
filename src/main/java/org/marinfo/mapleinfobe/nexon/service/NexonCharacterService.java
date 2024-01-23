package org.marinfo.mapleinfobe.nexon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.nexon.dto.*;
import org.marinfo.mapleinfobe.nexon.search.NexonOcidSearch;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class NexonCharacterService {
    private final NexonIdentifyService nexonIdentifyService;

    public CharacterBasic getCharacterBasic(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_BASIC, makeLatestSearchParams(characterName));
    }

    public CharacterStat getCharacterStat(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_STAT, makeLatestSearchParams(characterName));
    }

    public CharacterHyperStat getCharacterHyperStat(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_HYPER_STAT, makeLatestSearchParams(characterName));
    }

    public CharacterItemEquipment getCharacterItemEquipment(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_ITEM_EQUIPMENT, makeLatestSearchParams(characterName));
    }

    public CharacterLinkSkill getCharacterLinkSkill(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_LINK_SKILL, makeLatestSearchParams(characterName));
    }

    public CharacterVmatrix getCharacterVmatrix(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.CHARACTER_VMATRIX, makeLatestSearchParams(characterName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String characterName) {
        var ocid = nexonIdentifyService.getOcid(characterName);
        var nexonOcidSearch = NexonOcidSearch.create(ocid);
        return nexonOcidSearch.toMultiValueMap();
    }
}
