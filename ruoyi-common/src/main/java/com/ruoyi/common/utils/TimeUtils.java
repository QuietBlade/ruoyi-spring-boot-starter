package com.ruoyi.common.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author: world
 * @date: 2022/5/17 16:28
 * @description: 时间转换工具
 */
public class TimeUtils {
    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        // 将此日期时间与时区相结合以创建 ZonedDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        // 本地时间线LocalDateTime到即时时间线Instant时间戳
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
    }
}
