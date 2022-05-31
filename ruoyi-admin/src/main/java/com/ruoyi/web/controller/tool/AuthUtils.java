package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: world
 * @date: 2022/5/11 16:44
 * @description: 用于验证用户有某种权限
 */

@Component
public class AuthUtils {


    @Getter
    @AllArgsConstructor
    public enum RoleEnums{
        Admin("admin","超级管理员"),
        Proprieter("proprieter","社长"),
        Teatcher("teatcher","指导老师"),
        ;
        private String key;
        private String name;
    }

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    public boolean isAdmin(){
        return this.isRoleOr(RoleEnums.Admin,RoleEnums.Proprieter,RoleEnums.Teatcher);
    }

    public boolean isRole(RoleEnums roleEnum){
        final List<SysRole> sysRoles = roleService.selectRolesByUserId(SecurityUtils.getUserId());
        final List<SysRole> collect = sysRoles.stream().filter(
                item -> item.getRoleKey().equals(roleEnum.getKey())
        ).collect(Collectors.toList());
        return !collect.isEmpty();
    }

    public boolean isRoleAnd(RoleEnums... roleEnums){
        final List<SysRole> sysRoles = roleService.selectRolesByUserId(SecurityUtils.getUserId());
        boolean res = true;
        for (RoleEnums roleEnum : roleEnums){
            final List<SysRole> collect = sysRoles.stream().filter(
                    item -> item.getRoleKey().equals(roleEnum.getKey())
            ).collect(Collectors.toList());
            if (collect.isEmpty()){
                res = false;
                break;
            }
        }
        return res;
    }

    public boolean isRoleOr(RoleEnums... roleEnums){
        final List<SysRole> sysRoles = roleService.selectRolesByUserId(SecurityUtils.getUserId());
        boolean res = false;
        for (RoleEnums roleEnum : roleEnums){
            final List<SysRole> collect = sysRoles.stream().filter(
                    item -> item.getRoleKey().equals(roleEnum.getKey())
            ).collect(Collectors.toList());
            if (!collect.isEmpty()){
                res = true;
                break;
            }
        }
        return res;
    }
}
