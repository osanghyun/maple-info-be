package org.marinfo.mapleinfobe.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NexonUriPath {
    private static final String PREFIX = "maplestory/v1";

    // IDENTIFY
    public static final String OCID = PREFIX + "/id";
    public static final String GUILD_ID = PREFIX + "/guild/id";

    // CHARACTER
    public static final String CHARACTER_BASIC = PREFIX + "/character/basic";
    public static final String CHARACTER_STAT = PREFIX + "/character/stat";
    public static final String CHARACTER_HYPER_STAT = PREFIX + "/character/hyper-stat";
    public static final String CHARACTER_ITEM_EQUIPMENT = PREFIX + "/character/item-equipment";
    public static final String CHARACTER_VMATRIX = PREFIX + "/character/vmatrix";
    public static final String CHARACTER_LINK_SKILL = PREFIX + "/character/link-skill";

    // UNION
    public static final String UNION = PREFIX + "/user/union";
    public static final String UNION_RAIDER = PREFIX + "/user/union-raider";

    // GUILD
    public static final String GUILD_BASIC = PREFIX + "/guild/basic";

    // RANK
    public static final String RANK_OVERALL = PREFIX + "/ranking/overall";
}
