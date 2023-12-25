package org.marinfo.mapleinfobe.nexon.service;

import jakarta.validation.constraints.NotBlank;
import org.marinfo.mapleinfobe.nexon.search.NexonOguildIdSearch;
import org.marinfo.mapleinfobe.nexon.dto.GuildBasic;
import org.marinfo.mapleinfobe.nexon.dto.OguildId;
import org.marinfo.mapleinfobe.constant.NexonUriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class GuildService {


    public GuildBasic getGuildBasic(String guildName, String worldName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.GUILD_BASIC, makeLatestSearchParams(guildName, worldName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String guildName, String worldName) {
        var oguildId = getOguildId(guildName, worldName);
        var guildSearch = NexonOguildIdSearch.create(oguildId);
        return guildSearch.toMultiValueMap();
    }

    private String getOguildId(@NotBlank String guildName, @NotBlank String worldName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("guild_name", guildName);
        params.set("world_name", worldName);
        OguildId result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, NexonUriPath.GUILD_ID, params);
        return result.getOguildId();
    }
}
