package org.marinfo.mapleinfobe.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UriPath {
    private static final String PREFIX = "maplestory/v1";
    public static final String CHARACTER_OCID = PREFIX + "/id";
}
