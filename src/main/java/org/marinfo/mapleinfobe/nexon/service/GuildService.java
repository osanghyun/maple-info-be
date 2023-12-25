package org.marinfo.mapleinfobe.nexon.service;

import lombok.RequiredArgsConstructor;
import org.marinfo.mapleinfobe.nexon.search.NexonOguildIdSearch;
import org.marinfo.mapleinfobe.nexon.dto.GuildBasic;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class GuildService {
    private final IdentifyService identifyService;


    public GuildBasic getGuildBasic(String guildName, String worldName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.GUILD_BASIC, makeLatestSearchParams(guildName, worldName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String guildName, String worldName) {
        var oguildId = identifyService.getOguildId(guildName, worldName);
        var nexonOguildIdSearch = NexonOguildIdSearch.create(oguildId);
        return nexonOguildIdSearch.toMultiValueMap();
    }
}
