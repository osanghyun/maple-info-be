package org.marinfo.mapleinfobe.api.guild.service;

import jakarta.validation.constraints.NotBlank;
import org.marinfo.mapleinfobe.api.guild.search.GuildSearch;
import org.marinfo.mapleinfobe.api.guild.vo.GuildBasic;
import org.marinfo.mapleinfobe.api.guild.vo.OguildId;
import org.marinfo.mapleinfobe.constant.UriPath;
import org.marinfo.mapleinfobe.util.NexonOpenApiClientUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class GuildService {


    public GuildBasic getGuildBasic(String guildName, String worldName) {
        return NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, UriPath.GUILD_BASIC, makeLatestSearchParams(guildName, worldName));
    }

    private MultiValueMap<String, String> makeLatestSearchParams(String guildName, String worldName) {
        var oguildId = getOguildId(guildName, worldName);
        var guildSearch = GuildSearch.create(oguildId);
        return guildSearch.toMultiValueMap();
    }

    private String getOguildId(@NotBlank String guildName, @NotBlank String worldName) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("guild_name", guildName);
        params.set("world_name", worldName);
        OguildId result = NexonOpenApiClientUtil.httpGetRequest(new ParameterizedTypeReference<>() {}, UriPath.GUILD_ID, params);
        return result.getOguildId();
    }
}
