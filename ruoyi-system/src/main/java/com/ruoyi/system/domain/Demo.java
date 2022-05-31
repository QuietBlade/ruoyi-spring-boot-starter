package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: world
 * @date: 2022/5/12 15:59
 * @description: 测试表
 */

@TableName(value = "demo",autoResultMap = true)
public class Demo {

    private Long id;

    private Long userId;

    private Long clubId;

    @TableField(value = "(SELECT user_name FROM sys_user WHERE sys_user.user_id = demo.user_id)",updateStrategy = FieldStrategy.NEVER)
    private String userName;

    @TableField(value = "(SELECT nick_name FROM sys_user WHERE sys_user.user_id = demo.user_id)",updateStrategy = FieldStrategy.NEVER)
    private String nickName;

    @TableField(value = "(SELECT `name` FROM sys_club WHERE sys_club.id = demo.club_id)",updateStrategy = FieldStrategy.NEVER)
    private String clubName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getUserName() {
        return userName;
    }

    public String getClubName() {
        return clubName;
    }
}
