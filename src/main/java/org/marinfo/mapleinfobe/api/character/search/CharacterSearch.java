package org.marinfo.mapleinfobe.api.character.search;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.marinfo.mapleinfobe.util.DateTimeUil;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@ToString
@NoArgsConstructor
public class CharacterSearch {
    private String ocid;
    private String date;

    public static CharacterSearch create(@NotBlank String ocid) {
        var characterSearch = new CharacterSearch();

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
