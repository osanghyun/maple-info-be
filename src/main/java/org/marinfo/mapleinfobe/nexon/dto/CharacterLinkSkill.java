package org.marinfo.mapleinfobe.nexon.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CharacterLinkSkill {
    private String date;
    @JsonAlias({"character_class"})
    private String characterClass;
    @JsonAlias({"character_link_skill"})
    private List<LinkSkill> characterLinkSkillList;
    @JsonAlias({"character_owned_link_skill"})
    private LinkSkill characterOwnedLinkSkill;

    @Getter
    @Setter
    @ToString
    public static class LinkSkill {
        @JsonAlias({"skill_name"})
        private String skillName;
        @JsonAlias({"skill_description"})
        private String skillDescription;
        @JsonAlias({"skill_level"})
        private Integer skillLevel;
        @JsonAlias({"skill_effect"})
        private String skillEffect;
        @JsonAlias({"skill_icon"})
        private String skillIcon;
    }
}
