package org.marinfo.mapleinfobe.nexon.service;

import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.nexon.dto.UnionBasic;
import org.marinfo.mapleinfobe.nexon.dto.UnionRaider;
import org.marinfo.mapleinfobe.nexon.search.NexonOcidSearch;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class NexonUnionService {
    private final NexonIdentifyService nexonIdentifyService;

    public UnionBasic getUnionBasic(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.UNION, makeLatestSearchParams(characterName));
    }

    public UnionRaider getUnionRaider(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.UNION_RAIDER, makeLatestSearchParams(characterName));
    }


    private MultiValueMap<String, String> makeLatestSearchParams(String characterName) {
        var ocid = nexonIdentifyService.getOcid(characterName);
        var nexonOcidSearch = NexonOcidSearch.create(ocid);
        return nexonOcidSearch.toMultiValueMap();
    }
}
