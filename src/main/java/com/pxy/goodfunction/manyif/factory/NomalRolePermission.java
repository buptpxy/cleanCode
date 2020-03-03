package com.pxy.goodfunction.manyif.factory;

import com.pxy.goodfunction.manyif.RolePermission;

public class NomalRolePermission implements RolePermission {
    private String roleName;

    public NomalRolePermission(String roleName) {
        this.roleName = roleName;
    }

    public String permission() {
        return roleName + " has C permission";
    }
}
