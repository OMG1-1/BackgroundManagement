package com.kss.jt.system.service;

import com.kss.jt.domain.Node;
import com.kss.jt.system.domain.SysDept;

import java.util.List;
import java.util.Map;

public interface SysDeptService {
    List<Map<String,Object>> selectDepts();
    List<Node> selectDeptTreeNodes();
    List<SysDept> selectDept(Integer id);
    int insertDept(SysDept entity);
    int updateDept(SysDept entity);

}
