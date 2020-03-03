package com.pxy.goodfunction.manyif.factory;

import com.pxy.goodfunction.manyif.RolePermission;

import java.util.HashMap;

public class RolePermissionFactory {
    private static HashMap<String, RolePermission> rolePermissionMap = new HashMap<String, RolePermission>();
    static {
        rolePermissionMap.put("ROOT_ADMIN_ROLE",new RootAdminRolePermission("ROOT_ADMIN_ROLE"));
        rolePermissionMap.put("ORDER_ADMIN_ROLE",new OrderAdminRolePermission("ORDER_ADMIN_ROLE"));
        rolePermissionMap.put("NORMAL_ROLE",new NomalRolePermission("NORMAL_ROLE"));
    }
    public static RolePermission newRolePermissionInstance(String roleName){
        return rolePermissionMap.get(roleName);
    }
}
