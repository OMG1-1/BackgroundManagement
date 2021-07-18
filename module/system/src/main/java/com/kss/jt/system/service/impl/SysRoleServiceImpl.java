package com.kss.jt.system.service.impl;

import com.kss.jt.common.ServiceException;
import com.kss.jt.system.Dao.SysRoleDao;
import com.kss.jt.system.Dao.SysRoleMenuDao;
import com.kss.jt.system.domain.SysRole;
import com.kss.jt.system.service.SysRoleService;
import javafx.scene.control.CheckBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    public List<CheckBox> selectCheckRoles(){
        //....
        return sysRoleDao.selectCheckRoles();
    }
    public SysRole selectById(Integer id){
        SysRole roleMenu=sysRoleDao.selectById(id);//id,name,note
        if(roleMenu==null)
            throw new ServiceException("记录可能已经不存在");
        return roleMenu;
    }

    @Override
    public int updateRole(SysRole entity) {
        //1.参数校验(自己校验)
        //2.保存角色自身信息
        int rows=sysRoleDao.updateRole(entity);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        //3.更新角色和菜单关系数据
        sysRoleMenuDao.deleteByRoleId(entity.getId());
        //System.out.println("menuIds="+Arrays.toString(menuIds));
        sysRoleMenuDao.insertRoleMenus(
                entity.getId(),entity.getMenuIds());
        return rows;
    }
    @Override
    public int insertRole(SysRole entity) {
        //1.参数校验(自己校验)
        //2.保存角色自身信息
        int rows=sysRoleDao.insertRole(entity);
        //3.保存角色和菜单关系数据
        sysRoleMenuDao.insertRoleMenus(
                entity.getId(),entity.getMenuIds());
        return rows;
    }
    @Override
    public List<SysRole> selectRoles(SysRole entity) {
        return  sysRoleDao.selectRoles(entity);
    }
}
