package com.kevin.mem.mng.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoField.*;

public class JsonUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);
    private static final DateTimeFormatter MY_DATE_TIME;
    private static final DateTimeFormatter MY_DATE;

    static {
        MY_DATE_TIME = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('-')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('-')
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral(' ')
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 2)
                .toFormatter();
    }

    static {
        MY_DATE = new DateTimeFormatterBuilder()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('-')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('-')
                .appendValue(DAY_OF_MONTH, 2)
                .toFormatter();
    }

    static {
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        //LocalDateTime类型转换
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(MY_DATE_TIME));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(MY_DATE_TIME));
        OBJECT_MAPPER.registerModule(javaTimeModule);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    private static String writeValue(Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof String) {
            return (String) object;
        }

        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("writeJsonValue error, ", e);
        }
        return null;
    }

    private static <T> T readValue(String json, Class<T> t) {
        if (json == null) {
            return null;
        }

        try {
            return OBJECT_MAPPER.readValue(json, t);
        } catch (Exception e) {
            LOGGER.error("readJsonValue error, ", e);
        }
        return null;
    }

    private static <T> T readValue(String json, TypeReference<T> t) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, t);
        } catch (Exception e) {
            LOGGER.error("readJsonValue error, ", e);
        }
        return null;
    }


    /**
     * java对象转换为json字符串
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return writeValue(object);
    }


    /**
     * json转换为java对象
     *
     * @param json json
     * @param t    对象类型
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> t) {
        return readValue(json, t);
    }


    /**
     * json转换为List对象
     *
     * @param json json
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json) {
        return readValue(json, new TypeReference<List<T>>() {
        });
    }


    /**
     * json转换为Map对象
     *
     * @param json json
     * @return
     */
    public static <K, V> Map<K, V> toMap(String json) {
        return readValue(json, new TypeReference<Map<K, V>>() {
        });
    }


    /**
     * json转换为java对象
     *
     * @param json json
     * @param t    对象类型
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, TypeReference<T> t) {
        return readValue(json, t);
    }


}
