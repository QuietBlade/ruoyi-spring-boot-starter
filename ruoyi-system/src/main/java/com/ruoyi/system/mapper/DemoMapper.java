package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ruoyi.system.domain.Demo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: world
 * @date: 2022/5/12 16:00
 * @description:
 */
public interface DemoMapper extends BaseMapper<Demo> {
    @Select("SELECT * FROM (\n" +
            "SELECT d.*,u.nick_name as userName,c.`name` FROM demo d  \n" +
            "LEFT JOIN sys_user u ON u.user_id = d.user_id \n" +
            "left JOIN sys_club c on c.id = d.club_id) T ${ew.customSqlSegment}")
    public List<Demo> listLeft(@Param(Constants.WRAPPER) Wrapper wrapper);
}
