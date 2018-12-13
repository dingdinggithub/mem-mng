package com.kevin.mem.mng.dto.response;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author 丁海峰
 * @DateTime 2018/12/9 17:51
 * @Description
 */
@Data
@NoArgsConstructor
public class TreeDataDTO {
    private Long id = 0L;

    private String name = "根路径";

    private Long pid = 0L;

    private Boolean checked = false;

    private Boolean open = true;

    private List<TreeDataDTO> children;

    public TreeDataDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TreeDataDTO(Long id, String name, Boolean checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("{id : " + id +", name : '" + name + "', pid : " + pid + ", checked : " + checked +", open : " + open);

        if (CollectionUtils.isNotEmpty(this.getChildren())) {
            stringBuilder.append(",children : [");
            this.getChildren().forEach(item-> {
                stringBuilder.append(item.toString()) ;
                stringBuilder.append(",");
            });
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("]");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
