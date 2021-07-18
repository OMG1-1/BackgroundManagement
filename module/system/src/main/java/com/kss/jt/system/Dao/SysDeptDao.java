package com.kss.jt.system.Dao;

import com.kss.jt.domain.Node;

import com.kss.jt.system.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDeptDao {
    /**
     * 查询所有部门以及部门的上级菜单信息
     * @return
     */
    @Select("select c.*,p.name parentName from sys_depts c left join sys_depts p on c.parentId=p.id")
    List<Map<String,Object>> selectDepts();

    List<SysDept> selectById(Integer id);

    @Select("select id,name,parentId from sys_depts")
    List<Node> selectDeptTreeNodes();

    int updateDept(SysDept entity);
    int insertDept(SysDept entity);

}
