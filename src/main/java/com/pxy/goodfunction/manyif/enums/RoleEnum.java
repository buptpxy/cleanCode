package com.pxy.goodfunction.manyif.enums;

import com.pxy.goodfunction.manyif.RolePermission;

public enum RoleEnum implements RolePermission {
    /**
     * 系统管理员有A权限
     */
    ROLE_ROOT_ADMIN {
        public String permission(){
            return "ROOT_ADMIN_ROLE" + "has A permission";
        }
    },
    /**
     * 订单管理员有B权限
     */
    ROLE_ORDER_ADMIN {
        public String permission(){
            return "ORDER_ADMIN_ROLE" + "has B permission";
        }
    },
    /**
     * 普通用户有C权限
     */
    ROLE_NORMAL {
        public String permission(){
            return "ROOT_ADMIN_ROLE" + "has C permission";
        }
    }

}
