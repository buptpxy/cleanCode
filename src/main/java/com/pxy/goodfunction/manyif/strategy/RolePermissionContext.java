package com.pxy.goodfunction.manyif.strategy;

import com.pxy.goodfunction.manyif.RolePermission;

/**
 * 策略上下文类
 */
public class RolePermissionContext {
    RolePermission rolePermission;

    /**
     * 根据传入不同的"策略"对象（即角色），执行不同的业务逻辑
     * @param rolePermission
     */
    public RolePermissionContext(RolePermission rolePermission) {
        this.rolePermission = rolePermission;
    }

    public String execute() {
        return rolePermission.permission();
    }
}
