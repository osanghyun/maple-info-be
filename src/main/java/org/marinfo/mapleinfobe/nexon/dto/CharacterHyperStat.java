package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterHyperStat {
    private String date;
    @JsonAlias({"character_class"})
    private String characacterClass;
    @JsonAlias({"use_preset_no"})
    private String usePresentNo;
    @JsonAlias({"use_available_hyper_stat"})
    private Integer useAvailableHyperStat;
    @JsonAlias({"hyper_stat_preset_1"})
    private List<HyperStat> hyperStatPresent1List;
    @JsonAlias({"hyper_stat_preset_1_remain_point"})
    private Integer hyperStatPresent1RemainPoint;
    @JsonAlias({"hyper_stat_preset_2"})
    private List<HyperStat> hyperStatPresent2List;
    @JsonAlias({"hyper_stat_preset_2_remain_point"})
    private Integer hyperStatPresent2RemainPoint;
    @JsonAlias({"hyper_stat_preset_3"})
    private List<HyperStat> hyperStatPresent3List;
    @JsonAlias({"hyper_stat_preset_3_remain_point"})
    private Integer hyperStatPresent3RemainPoint;

    @Getter
    @Setter
    @ToString
    public static class HyperStat {
        @JsonAlias({"stat_type"})
        private String statType;
        @JsonAlias({"stat_point"})
        private Integer statPoint;
        @JsonAlias({"stat_level"})
        private Integer statLevel;
        @JsonAlias({"stat_increase"})
        private String statIncrease;
    }
}
