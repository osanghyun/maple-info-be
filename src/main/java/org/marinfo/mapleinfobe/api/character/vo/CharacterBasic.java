package org.marinfo.mapleinfobe.api.character.vo;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacterBasic {
    private String date;
    @JsonAlias({"character_name"})
    private String characterName;
    @JsonAlias({"world_name"})
    private String worldName;
    @JsonAlias({"character_gender"})
    private String characterGender;
    @JsonAlias({"character_class"})
    private String characterClass;
    @JsonAlias({"character_class_level"})
    private String characterClassLevel;
    @JsonAlias({"character_level"})
    private Long characterLevel;
    @JsonAlias({"character_exp"})
    private Long characterExp;
    @JsonAlias({"character_exp_rate"})
    private String characterExpRate;
    @JsonAlias({"character_guild_name"})
    private String characterGuildName;
    @JsonAlias({"character_image"})
    private String characterImage;

}
