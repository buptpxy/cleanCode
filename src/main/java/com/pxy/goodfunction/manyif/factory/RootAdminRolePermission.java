package com.pxy.goodfunction.manyif.factory;

import com.pxy.goodfunction.manyif.RolePermission;

public class RootAdminRolePermission implements RolePermission {
    private String roleName;

    public RootAdminRolePermission(String roleName) {
        this.roleName = roleName;
    }

    public String permission() {
        return roleName + " has A permission";
    }
}
