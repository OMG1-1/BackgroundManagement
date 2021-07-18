package com.kss.jt.system.service.impl;

import com.kss.jt.system.Dao.SysLogDao;
import com.kss.jt.system.domain.SysLog;
import com.kss.jt.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> selectLogs(SysLog sysLog) {
        return sysLogDao.selectLogs(sysLog);
    }

    @Override
    public SysLog selectById(Long id) {
        return sysLogDao.selectById(id);
    }

    @Override
    public int insertLog(SysLog sysLog) {
        return sysLogDao.insertLog(sysLog);
    }

    @Override
    public int deleteById(Long... id) {
        return sysLogDao.deleteById(id);
    }
}
