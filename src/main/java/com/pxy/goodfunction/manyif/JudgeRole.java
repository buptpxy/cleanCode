package com.pxy.goodfunction.manyif;

import com.pxy.goodfunction.manyif.enums.RoleEnum;
import com.pxy.goodfunction.manyif.factory.RolePermissionFactory;
import com.pxy.goodfunction.manyif.strategy.RolePermissionContext;

/**
 * 当系统中有很多角色类型，每种角色类型对应不同的权限
 */
public class JudgeRole {
    /**
     * if-else的连环写法
     * 当角色类型特别多时，这种写法占篇幅很大，且不易扩展
     * @param roleName
     * @return
     */
    public String judge(String roleName) {
        String result = "";
        if (roleName.equals("ROOT_ADMIN_ROLE")) { //系统管理员有A权限
            result = roleName + " has A permission";
        } else if (roleName.equals("ORDER_ADMIN_ROLE")) { //订单管理员有B权限
            result = roleName + " has B permission";
        } else if (roleName.equals("NORMAL_ROLE")) { //普通用户有C权限
            result = roleName + " has C permission";
        } else {
            result = roleName + " has no permission";
        }
        return result;
    }

    /**
     * 使用枚举类，定义每种角色的权限，无需if-else，要扩展时只需去枚举类里面增加角色就行，无需修改当前类的业务逻辑
     * @param roleName
     * @return
     */
    public String judgeByEnum(String roleName) {
        return RoleEnum.valueOf(roleName).permission();
    }

    /**
     * 使用工厂模式，为每个角色新建一个类，并定义这个角色的权限
     * 在工厂类中聚合这些角色，在此业务类中只需调工厂类即可
     * @param roleName
     * @return
     */
    public String judgeByFactory(String roleName){
        RolePermission rolePermission = RolePermissionFactory.newRolePermissionInstance(roleName);
        return rolePermission.permission();
    }

    /**
     * 使用策略模式，创建一个策略上下文，根据传入的不同对象执行对应的业务逻辑
     * @param rolePermission
     * @return
     */
    public String judgeByStrategy(RolePermission rolePermission){
        RolePermissionContext roleContext = new RolePermissionContext(rolePermission);
        return roleContext.execute();
    }

}
