package com.kevin.mem.mng.common.dozerConvert;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;

public class LocalDateTimeToLocalDateTimeDozerConverter extends DozerConverter<LocalDateTime, LocalDateTime> {
    public LocalDateTimeToLocalDateTimeDozerConverter() {
        super(LocalDateTime.class, LocalDateTime.class);
    }

    public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
        return source;
    }

    public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
        return source;
    }
}