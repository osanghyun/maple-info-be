package org.marinfo.mapleinfobe.nexon.search;

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
public class NexonOguildIdSearch {
    private String oguildId;
    private String date;

    public static NexonOguildIdSearch create(@NotBlank String oguildId) {
        var guildSearch = new NexonOguildIdSearch();

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
