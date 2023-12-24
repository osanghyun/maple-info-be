package org.marinfo.mapleinfobe.api.guild.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.marinfo.mapleinfobe.util.DateTimeUil;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@ToString
@NoArgsConstructor
public class GuildSearch {
    private String oguildId;
    private String date;

    public static GuildSearch create(@NotBlank String oguildId) {
        var guildSearch = new GuildSearch();

        guildSearch.setOguildId(oguildId);
        guildSearch.setDate();

        return guildSearch;
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("oguild_id", oguildId);
        params.set("date", date);

        return params;
    }

    private void setOguildId(String oguildId) {
        this.oguildId = oguildId;
    }
    private void setDate() {
        this.date = DateTimeUil.getCharacterSearchLatestDate();
    }
}
