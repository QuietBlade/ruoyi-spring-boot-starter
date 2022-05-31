package com.ruoyi.common.core.domain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BasePage {
    @ApiModelProperty(value = "当前页面", notes = "默认1", example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "每页显示条数", notes = "默认20", example = "20")
    private Long size = 20L;

    @ApiModelProperty(value = "排序字段", notes = "对于model字段,会自动转换驼峰命名")
    private String sort;

    @ApiModelProperty(value = "排序类型", notes = "asc 或者 desc", allowableValues = "asc,desc")
    private String order;

    // 是否降序
    public boolean isDesc(){
        if (order == null || order.equals("desc")){
            return false;
        }
        return true;
    }

    public <T> IPage<T> getIPage(Class<T> tClass){
        return new Page<T>(current,size);
    }

    /**
     * 自动转换驼峰
     * @return
     */
    public String getSort() {
        return StringUtils.camelToUnderline(sort);
    }
}
