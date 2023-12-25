package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterItemEquipment {
    private String date;
    @JsonAlias({"character_gender"})
    private String characterGender;
    @JsonAlias({"character_class"})
    private String characterClass;
    @JsonAlias({"item_equipment"})
    private List<ItemEquipment> itemEquipmentList;
    private Title title;
    @JsonAlias({"dragon_equipment"})
    private List<ClassSpecificItemEquipment> dragonEquipmentList;
    @JsonAlias({"mechanic_equipment"})
    private List<ClassSpecificItemEquipment> mechanicEquipmentList;


    @Getter
    @Setter
    @ToString
    public static class ItemEquipment {
        @JsonAlias({"item_equipment_part"})
        private String itemEquipmentPart;
        @JsonAlias({"item_equipment_slot"})
        private String equipmentSlot;
        @JsonAlias({"item_name"})
        private String itemName;
        @JsonAlias({"item_icon"})
        private String itemIcon;
        @JsonAlias({"item_description"})
        private String itemDescription;
        @JsonAlias({"item_shape_name"})
        private String itemShapeName;
        @JsonAlias({"item_shape_icon"})
        private String itemShapeIcon;
        @JsonAlias({"item_gender"})
        private String itemGender;
        @JsonAlias({"item_total_option"})
        private ItemTotalOption itemTotalOption;
        @JsonAlias({"item_base_option"})
        private ItemBaseOption itemBaseOption;
        @JsonAlias({"potential_option_grade"})
        private String potentialOptionGrade;
        @JsonAlias({"additional_potential_option_grade"})
        private String additionalPotentialOptionGrade;
        @JsonAlias({"potential_option_1"})
        private String potentialOption1;
        @JsonAlias({"potential_option_2"})
        private String potentialOption2;
        @JsonAlias({"potential_option_3"})
        private String potentialOption3;
        @JsonAlias({"additional_potential_option_1"})
        private String additionalPotentialOption1;
        @JsonAlias({"additional_potential_option_2"})
        private String additionalPotentialOption2;
        @JsonAlias({"additional_potential_option_3"})
        private String additionalPotentialOption3;
        @JsonAlias({"equipment_level_increase"})
        private Integer equipmentLevelIncrease;
        @JsonAlias({"item_exceptional_option"})
        private ItemExceptionalOption itemExceptionalOption;
        @JsonAlias({"item_add_option"})
        private ItemAddOption itemAddOption;
        @JsonAlias({"growth_exp"})
        private Long growthExp;
        @JsonAlias({"growth_level"})
        private Long growthLevel;
        @JsonAlias({"scroll_upgrade"})
        private String scrollUpgrade;
        @JsonAlias({"cuttable_count"})
        private String cuttableCount;
        @JsonAlias({"golden_hammer_flag"})
        private String goldenHammerFlag;
        @JsonAlias({"scroll_resilience_count"})
        private String scrollResilienceCount;
        @JsonAlias({"scroll_upgradeable_count"})
        private String scrollUpgradeableCount;
        @JsonAlias({"soul_name"})
        private String soulName;
        @JsonAlias({"soul_option"})
        private String soulOption;
        @JsonAlias({"item_etc_option"})
        private ItemEtcOption itemEtcOption;
        @JsonAlias({"starforce"})
        private String starforce;
        @JsonAlias({"starforce_scroll_flag"})
        private String starforceScrollFlag;
        @JsonAlias({"item_starforce_option"})
        private ItemStarforceOption itemStarforceOption;
        @JsonAlias({"special_ring_level"})
        private Integer specialRingLevel;
        @JsonAlias({"date_expire"})
        private String dateExpire;
    }

    @Getter
    @Setter
    @ToString
    public static class Title {
        @JsonAlias({"title_name"})
        private String titleName;
        @JsonAlias({"title_icon"})
        private String titleIcon;
        @JsonAlias({"title_description"})
        private String titleDescription;
        @JsonAlias({"date_expire"})
        private String dateExpire;
        @JsonAlias({"date_option_expire"})
        private String dateOptionExpire;
    }

    @Getter
    @Setter
    @ToString
    public static class ClassSpecificItemEquipment{
        @JsonAlias({"item_equipment_part"})
        private String itemEquipmentPart;
        @JsonAlias({"equipment_slot"})
        private String equipmentSlot;
        @JsonAlias({"item_name"})
        private String itemName;
        @JsonAlias({"item_icon"})
        private String itemIcon;
        @JsonAlias({"item_description"})
        private String itemDescription;
        @JsonAlias({"item_shape_name"})
        private String itemShapeName;
        @JsonAlias({"item_shape_icon"})
        private String itemShapeIcon;
        private String gender;
        @JsonAlias({"item_total_option"})
        private ItemTotalOption itemTotalOption;
        @JsonAlias({"item_base_option"})
        private ItemBaseOption itemBaseOption;
        @JsonAlias({"equipment_level_increase"})
        private Integer equipmentLevelIncrease;
        @JsonAlias({"item_exceptional_option"})
        private ItemExceptionalOption itemExceptionalOption;
        @JsonAlias({"item_add_option"})
        private ItemAddOption itemAddOption;
        @JsonAlias({"growth_exp"})
        private Long growthExp;
        @JsonAlias({"growth_level"})
        private Long growthLevel;
        @JsonAlias({"scroll_upgrade"})
        private String scrollUpgrade;
        @JsonAlias({"cuttable_count"})
        private String cuttableCount;
        @JsonAlias({"golden_hammer_flag"})
        private String goldenHammerFlag;
        @JsonAlias({"scroll_resilience_count"})
        private String scrollResilienceCount;
        @JsonAlias({"scroll_upgradeable_count"})
        private String scrollUpgradeableCount;
        @JsonAlias({"soul_name"})
        private String soulName;
        @JsonAlias({"soul_option"})
        private String soulOption;
        @JsonAlias({"item_etc_option"})
        private ItemEtcOption itemEtcOption;
        @JsonAlias({"starforce"})
        private String starforce;
        @JsonAlias({"starforce_scroll_flag"})
        private String starforceScrollFlag;
        @JsonAlias({"item_starforce_option"})
        private ItemStarforceOption itemStarforceOption;
        @JsonAlias({"special_ring_level"})
        private Integer specialRingLevel;
        @JsonAlias({"date_expire"})
        private String dateExpire;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemTotalOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
        private String armor;
        private String speed;
        private String jump;
        @JsonAlias({"boss_damage"})
        private String bossDamage;
        @JsonAlias({"ignore_monster_armor"})
        private String ignoreMonsterArmor;
        @JsonAlias({"all_stat"})
        private String allStat;
        private String damage;
        @JsonAlias({"equipment_level_decrease"})
        private Integer EquipmentLevelDecrease;
        @JsonAlias({"max_hp_rate"})
        private String maxHpRate;
        @JsonAlias({"max_mp_rate"})
        private String maxMpRate;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemBaseOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
        private String armor;
        private String speed;
        private String jump;
        @JsonAlias({"boss_damage"})
        private String bossDamage;
        @JsonAlias({"ignore_monster_armor"})
        private String ignoreMonsterArmor;
        @JsonAlias({"all_stat"})
        private String allStat;
        @JsonAlias({"max_hp_rate"})
        private String maxHpRate;
        @JsonAlias({"max_mp_rate"})
        private String maxMpRate;
        @JsonAlias({"base_equipment_level"})
        private Integer baseEquipmentLevel;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemExceptionalOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemAddOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
        private String armor;
        private String speed;
        private String jump;
        @JsonAlias({"boss_damage"})
        private String bossDamage;
        private String damage;
        @JsonAlias({"all_stat"})
        private String allStat;
        @JsonAlias({"equipment_level_decrease"})
        private Integer equipmentLevelDecrease;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemEtcOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
        private String armor;
        private String speed;
        private String jump;
    }

    @Getter
    @Setter
    @ToString
    public static class ItemStarforceOption {
        private String str;
        private String dex;
        @JsonProperty("int")
        private String intelligence;
        private String luk;
        @JsonAlias({"max_hp"})
        private String maxHp;
        @JsonAlias({"max_mp"})
        private String maxMp;
        @JsonAlias({"attack_power"})
        private String attackPower;
        @JsonAlias({"magic_power"})
        private String magicPower;
        private String armor;
        private String speed;
        private String jump;
    }
}
