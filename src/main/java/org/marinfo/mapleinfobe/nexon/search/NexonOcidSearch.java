package org.marinfo.mapleinfobe.nexon.search;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.marinfo.mapleinfobe.util.DateTimeUil;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@ToString
@NoArgsConstructor
public class NexonOcidSearch {
    private String ocid;
    private String date;

    public static NexonOcidSearch create(@NotBlank String ocid) {
        var characterSearch = new NexonOcidSearch();

        characterSearch.setOcid(ocid);
        characterSearch.setDate();

        return characterSearch;
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("ocid", ocid);
        params.set("date", date);

        return params;
    }

    private void setOcid(String ocid) {
        this.ocid = ocid;
    }

    private void setDate() {
        this.date = DateTimeUil.getCharacterSearchLatestDate();
    }
}
