package org.marinfo.mapleinfobe.api.guild.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GuildBasic {
    private String date;
    @JsonAlias({"world_name"})
    private String wolrdName;
    @JsonAlias({"guild_name"})
    private String guildName;
    @JsonAlias({"guild_level"})
    private Long guildLevel;
    @JsonAlias({"guild_fame"})
    private Long guildFame;
    @JsonAlias({"guild_point"})
    private Long guildPoint;
    @JsonAlias({"guild_master_name"})
    private String guildMasterName;
    @JsonAlias({"guild_member_count"})
    private Long guildMemberCount;
    @JsonAlias({"guild_member"})
    private List<String> guildMemberList;
    @JsonAlias({"guild_skill"})
    private List<GuildSkill> guildSkillList;
    @JsonAlias({"guild_nobless_skill"})
    private List<GuildSkill> guildNoblessSkill;
    @JsonAlias({"guild_mark"})
    private String guildMark;
    @JsonAlias({"guild_mark_custom"})
    private String guildMarkCustom;

    @Getter
    @Setter
    @ToString
    public static class GuildSkill {
        @JsonAlias({"skill_name"})
        private String skillName;
        @JsonAlias({"skill_description"})
        private String skillDescription;
        @JsonAlias({"skill_level"})
        private Long skillLevel;
        @JsonAlias({"skill_effect"})
        private String skillEffect;
        @JsonAlias({"skill_icon"})
        private String skillIcon;
    }
}
