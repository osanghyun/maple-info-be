package org.marinfo.mapleinfobe.api.character.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
public class CharacterOcidRequest {
    private String characterName;

    public MultiValueMap<String, String> toQueryParams() {
        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("character_name", characterName);
        return params;
    }
}
