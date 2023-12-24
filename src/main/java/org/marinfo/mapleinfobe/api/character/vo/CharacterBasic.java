package org.marinfo.mapleinfobe.api.character.vo;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CharacterBasic {
    private String date;
    private String characterName;
    private String worldName;
    private String characterGender;
    private String characterClass;
    private String characterClassLevel;
    private Long characterLevel;
    private Long characterExp;
    private String characterExpRate;
    private String characterGuildName;
    private String characterImage;

}
