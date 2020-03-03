package com.pxy.goodfunction.manyif.factory;

import com.pxy.goodfunction.manyif.RolePermission;

public class OrderAdminRolePermission implements RolePermission {
    private String roleName;

    public OrderAdminRolePermission(String roleName) {
        this.roleName = roleName;
    }

    public String permission() {
        return roleName + " has B permission";
    }
}
