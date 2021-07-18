package com.kss.jt.system.service.impl;

import com.kss.jt.common.ServiceException;
import com.kss.jt.system.Dao.SysUserDao;
import com.kss.jt.system.Dao.SysUserRoleDao;
import com.kss.jt.system.domain.SysUser;
import com.kss.jt.system.service.SysDeptService;
import com.kss.jt.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public List<SysUser> selectUsers(SysUser entity) {
        List<SysUser> userList = sysUserDao.selectUsers(entity);
        return userList;
    }

    @Override
    public SysUser selectById(Integer id) {
        SysUser user = sysUserDao.selectById(id);
        return user;
    }

    @Override
    public int insertUser(SysUser entity) {
        /*随机加密盐*/
        String salt = UUID.randomUUID().toString();
        /*对密码进行MD5盐值加密(MD5特点:不可逆,相同内容加密结果也相同)*/
        String asHex = DigestUtils.md5DigestAsHex((entity.getPassword() + salt)
                .getBytes(StandardCharsets.UTF_8));
        entity.setSalt(salt);
        /*toHex:字符串转码【转为16进制】*/
        entity.setPassword(asHex);
        int rows = sysUserRoleDao.insertUserRoles(entity.getId(), entity.getRoleIds());
        return rows;
    }

    @Override
    public int updateUser(SysUser entity) {
        /*开启事务*/
        /*更新用户自身信息*/
        int rows = sysUserDao.updateUser(entity);
        if(rows==0) throw new ServiceException("该记录可能已经飞走了！");
        /*更新用户和角色关系数据（先删除该用户原有的权限，然后再此用户名下基于传入的ids进行新增）*/
        sysUserRoleDao.deleteByUserId(entity.getId());
        sysUserRoleDao.insertUserRoles(entity.getId(),entity.getRoleIds());
        return rows;
    }

    @Override
    public int validById(Integer id, Integer valid) {
        int rows = validById(id, valid);
        if (rows == 0) {
            throw new ServiceException("真不巧，记录不见了！");
        }
        return rows;
    }

    /**
     * findUsers 查找用户
     * */
    @Override
    public List<SysUser> findUsers(SysUser sysUser){
        return sysUserDao.selectUsers(sysUser);
    }

    /**
     * saveUser 保存用户
     * */
    @Override
    public int saveUser(SysUser entity) {
        int rows = sysUserDao.updateUser(entity);
        return rows;
    }
    /**
     * findById 基于Id查找用户
     * */
    @Override
    public Object findById(Integer id) {
        return sysUserDao.selectById(id);
    }
}