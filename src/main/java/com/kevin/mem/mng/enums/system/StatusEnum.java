package com.kevin.mem.mng.enums.system;

import com.kevin.mem.mng.dto.response.KeyValueLevelDTO;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author 丁海峰
 * @DateTime 2018/12/9 17:44
 * @Description
 */
@Getter
public enum StatusEnum {
    NORMAL_STATUS(0, "正常"),
    CLOSED_STATUS(1, "关闭"),

    ;

    private final Integer code;
    private final String desc;

    StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDesc(Integer code) {
        Optional<StatusEnum> removeMethodEnum = Arrays.stream(StatusEnum.values())
                .filter(c -> c.getCode().equals(code)).findFirst();
        return removeMethodEnum.map(StatusEnum::getDesc).orElse(StringUtils.EMPTY);
    }

    public static Optional<StatusEnum> ofEnum(Integer code) {
        return Arrays.stream(StatusEnum.values())
                                .filter(c -> c.getCode()
                                        .equals(code)).findFirst();
    }


    public static List<KeyValueLevelDTO> getList() {
        return Arrays.stream(StatusEnum.values()).map(c -> {
            final KeyValueLevelDTO dictDTO = new KeyValueLevelDTO();
            dictDTO.setCode(c.getCode());
            dictDTO.setDesc(c.getDesc());
            return dictDTO;
        }).collect(Collectors.toList());
    }

}
