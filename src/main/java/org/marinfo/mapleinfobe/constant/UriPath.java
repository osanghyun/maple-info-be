package org.marinfo.mapleinfobe.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UriPath {
    private static final String PREFIX = "maplestory/v1";
    public static final String CHARACTER_OCID = PREFIX + "/id";
    public static final String CHARACTER_BASIC = PREFIX + "/character/basic";
    public static final String CHARACTER_STAT = PREFIX + "/character/stat";
    public static final String CHARACTER_VMATRIX = PREFIX + "/character/vmatrix";

    public static final String GUILD_ID = PREFIX + "/guild/id";
    public static final String GUILD_BASIC = PREFIX + "/guild/basic";
}
