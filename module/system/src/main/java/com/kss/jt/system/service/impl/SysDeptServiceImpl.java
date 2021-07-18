package com.kss.jt.system.service.impl;

import com.kss.jt.domain.Node;
import com.kss.jt.system.Dao.SysDeptDao;
import com.kss.jt.system.domain.SysDept;
import com.kss.jt.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptDao sysDeptDao;

    @Override
    public List<Map<String, Object>> selectDepts() {
        List<Map<String, Object>> list = sysDeptDao.selectDepts();
        return list;
    }

    @Override
    public List<Node> selectDeptTreeNodes() {
        List<Node> nodes = sysDeptDao.selectDeptTreeNodes();
        return nodes;
    }

    @Override
    public List<SysDept> selectDept(Integer id) {
        List<SysDept> depts = sysDeptDao.selectById(id);
        return depts;
    }

    @Override
    public int insertDept(SysDept entity) {
        int rows = sysDeptDao.insertDept(entity);
        return rows;
    }

    @Override
    public int updateDept(SysDept entity) {
        int rows = sysDeptDao.updateDept(entity);
        return rows;
    }
}
