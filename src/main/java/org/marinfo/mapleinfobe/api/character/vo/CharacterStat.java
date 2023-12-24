package org.marinfo.mapleinfobe.api.character.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterStat {
    private String date;
    @JsonAlias({"character_class"})
    private String characterClass;
    @JsonAlias({"final_stat"})
    private List<FinalStat> finalStat;

    @Getter
    @Setter
    @ToString
    static class FinalStat {
        @JsonAlias({"stat_name"})
        private String statName;
        @JsonAlias({"stat_value"})
        private String statValue;
    }
}
