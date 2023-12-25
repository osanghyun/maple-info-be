package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Ranking {
    private List<RankOverall> ranking;

    @Getter
    @Setter
    @ToString
    public static class RankOverall {
        private String date;
        @JsonAlias({"world_name"})
        private String worldName;
        private Long ranking;
        @JsonAlias({"character_name"})
        private String characterName;
        @JsonAlias({"character_level"})
        private Integer characterLevel;
        @JsonAlias({"character_exp"})
        private Long characterExp;
        @JsonAlias({"class_name"})
        private String className;
        @JsonAlias({"sub_class_name"})
        private String subClassName;
        @JsonAlias({"character_popularity"})
        private Long characterPopularity;
        @JsonAlias({"character_guildname"})
        private String characterGuildName;
    }

}
