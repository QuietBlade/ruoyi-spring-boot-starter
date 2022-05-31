package com.ruoyi.common.enums;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: world
 * @date: 2022/5/30 11:09
 * @description: 用于存储消息编码
 */
@AllArgsConstructor
public enum MessageContents {
    /**
     * 失败code
     */
    Failed("failed");

    /**
     * i18n文件中的状态码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
