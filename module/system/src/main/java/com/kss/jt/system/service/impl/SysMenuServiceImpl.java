package com.kss.jt.system.service.impl;

import com.kss.jt.domain.Node;
import com.kss.jt.system.Dao.SysMenuDao;
import com.kss.jt.system.domain.SysMenu;
import com.kss.jt.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;


    @Override
    public List<SysMenu> selectMenus() {
        return sysMenuDao.selectMenus();
    }

    @Override
    public SysMenu selectById(Integer id) {
        return sysMenuDao.selectById(id);
    }

    @Override
    public int insertMenu(SysMenu entity) {
        return sysMenuDao.insertMenu(entity);
    }

    @Override
    public int updateMenu(SysMenu entity) {
        return sysMenuDao.updateMenu(entity);
    }

    @Override
    public List<Node> selectMenuTreeNodes() {
        return sysMenuDao.selectMenuTreeNodes();
    }
}
