package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UnionRaider {
    private String date;
    @JsonAlias({"union_raider_stat"})
    private List<String> unionRaiderStatList;
    @JsonAlias({"union_occupied_stat"})
    private List<String> unionOccupiedStatList;
    @JsonAlias({"union_inner_stat"})
    private List<UnionInnerStat> unionInnerStatList;
    @JsonAlias({"union_block"})
    private List<UnionBlock> unionBlockList;

    @Getter
    @Setter
    @ToString
    public static class UnionInnerStat {
        @JsonAlias({"stat_field_id"})
        private String statFieldId;
        @JsonAlias({"stat_field_effect"})
        private String statFieldEffect;
    }

    @Getter
    @Setter
    @ToString
    public static class UnionBlock {
        @JsonAlias({"block_type"})
        private String blockType;
        @JsonAlias({"block_class"})
        private String blockClass;
        @JsonAlias({"block_level"})
        private String blockLevel;
        @JsonAlias({"block_control_point"})
        private Coordinates blockControlPoint;
        @JsonAlias({"block_position"})
        private List<Coordinates> blockPositionList;

        @Getter
        @Setter
        @ToString
        public static class Coordinates {
            private Integer x;
            private Integer y;
        }
    }

}
