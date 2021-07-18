package com.kss.jt.system.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * SysUserRoleDao 用户权限管理数据访问对象
 * */

@Mapper
public interface SysUserRoleDao {

    @Delete("delete from sys_user_roles where user_id=#{userId}")
    int deleteByUserId(Integer userId);

    @Select("select role_id from sys_user_roles where user_id=#{userId}")
    List<Integer> selectRoleIdsByUserId(Integer userId);

    /**
     * 添加用户权限操作
     * @Param userId 用户Id
     * @Param roleIds 权限Ids（可以有多个权限id）*/
    int insertUserRoles(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);

}
