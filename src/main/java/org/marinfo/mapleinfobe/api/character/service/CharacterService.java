package org.marinfo.mapleinfobe.api.character.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marinfo.mapleinfobe.api.character.dto.CharacterOcidRequest;
import org.marinfo.mapleinfobe.api.character.dto.CharacterOcidResponse;
import org.marinfo.mapleinfobe.constant.UriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterService {

    public CharacterOcidResponse getCharacterOcid(CharacterOcidRequest request) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, UriPath.CHARACTER_OCID, request.toQueryParams());
    }
}
