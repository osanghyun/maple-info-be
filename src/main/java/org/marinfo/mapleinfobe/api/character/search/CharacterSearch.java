package org.marinfo.mapleinfobe.api.character.search;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CharacterSearch {
    private String ocid;
    private String date;

    public static CharacterSearch create(@NotBlank String ocid) {
        var characterSearch = new CharacterSearch();

        characterSearch.setOcid(ocid);
        //TODO: date 계산 로직 추가 필요.
        characterSearch.setDate("2023-12-23");

        return characterSearch;
    }

    public MultiValueMap<String, String> toMultiValueMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("ocid", ocid);
        params.set("date", date);

        return params;
    }
}
