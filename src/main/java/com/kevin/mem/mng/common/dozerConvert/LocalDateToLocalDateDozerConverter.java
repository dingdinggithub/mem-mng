package com.kevin.mem.mng.common.dozerConvert;

import org.dozer.DozerConverter;

import java.time.LocalDate;

public class LocalDateToLocalDateDozerConverter extends DozerConverter<LocalDate, LocalDate> {
    public LocalDateToLocalDateDozerConverter() {
        super(LocalDate.class, LocalDate.class);
    }

    public LocalDate convertFrom(LocalDate source, LocalDate destination) {
        return source;
    }

    public LocalDate convertTo(LocalDate source, LocalDate destination) {
        return source;
    }
}
