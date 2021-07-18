package com.kss.jt.system.service;

import com.kss.jt.domain.Node;
import com.kss.jt.system.domain.SysMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 菜单逻辑业务操作的规范定义
 */
public interface SysMenuService {
    /**查询所有菜单信息以及菜单对应的上级菜单名称*/
    List<SysMenu> selectMenus();

    /**基于id查询菜单信息*/
    SysMenu selectById(Integer id);
    /**新增菜单信息*/
    int insertMenu(SysMenu entity);
    /**更新菜单信息*/
    int updateMenu(SysMenu entity);
    /**查找菜单树节点信息*/
    List<Node> selectMenuTreeNodes();
}
