package org.marinfo.mapleinfobe.nexon.service;

import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.nexon.dto.Ranking;
import org.marinfo.mapleinfobe.nexon.search.NexonOcidSearch;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;


@Service
@RequiredArgsConstructor
public class NexonRankService {
    private final NexonIdentifyService nexonIdentifyService;

    public Ranking getCharacterRankOverall(String characterName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.RANK_OVERALL, makeLatestSearchParams(characterName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String characterName) {
        var ocid = nexonIdentifyService.getOcid(characterName);
        var nexonOcidSearch = NexonOcidSearch.create(ocid);
        return nexonOcidSearch.toMultiValueMap();
    }
}
