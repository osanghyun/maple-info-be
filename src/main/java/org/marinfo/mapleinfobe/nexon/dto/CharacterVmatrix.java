package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterVmatrix {
    private String date;
    @JsonAlias({"character_class"})
    private String characterClass;
    @JsonAlias({"character_v_core_equipment"})
    private List<CharacterVcoreEquipment> characterVcoreEquipmentList;
    @JsonAlias({"character_v_matrix_remain_slot_upgrade_point"})
    private Long characterVmatrixRemainSlotUpgradePoint;

    @Getter
    @Setter
    @ToString
    public static class CharacterVcoreEquipment{
        @JsonAlias({"slot_id"})
        private String slotId;
        @JsonAlias({"slot_level"})
        private Long slotLevel;
        @JsonAlias({"v_core_name"})
        private String vcoreName;
        @JsonAlias({"v_core_type"})
        private String vcoreType;
        @JsonAlias({"v_core_level"})
        private Long vcoreLevel;
        @JsonAlias({"v_core_skill_1"})
        private String vcoreSkill1;
        @JsonAlias({"v_core_skill_2"})
        private String vcoreSkill2;
        @JsonAlias({"v_core_skill_3"})
        private String vcoreSkill3;
    }
}
