package org.marinfo.mapleinfobe.util;

import org.marinfo.mapleinfobe.MapleInfoBeApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUil {
    /**
     * 캐릭터 정보 업데이트 정책과 동일한 날짜 반환.
     * 오전 1시 이전 : 이틀전 날짜 반환.
     * 오전 1시 이후 : 전일 날짜 반환.
     * @return "YYYY-MM-DD"
     */
    public static String getCharacterSearchLatestDate() {
        var zoneId = MapleInfoBeApplication.config().getTimeZone();
        LocalDateTime nowDateTime = LocalDateTime.now(ZoneId.of(zoneId));

        var nowDate = nowDateTime.toLocalDate();

        if (nowDateTime.getHour() >= 1) {
            return nowDate.minusDays(1).toString();
        }
        else {
            return nowDate.minusDays(2).toString();
        }
    }
}
