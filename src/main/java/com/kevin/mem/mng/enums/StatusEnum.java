package com.kevin.mem.mng.enums;

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
    CLOSE_STATUS(0, "关闭"),
    OPEN_STATUS(1, "开启"),
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
            dictDTO.setCode(Long.valueOf(c.getCode()));
            dictDTO.setDesc(c.getDesc());
            return dictDTO;
        }).collect(Collectors.toList());
    }

}
