package com.kss.jt.system.service;

import com.kss.jt.system.domain.SysLog;

import java.util.List;

public interface SysLogService {

    List<SysLog> selectLogs(SysLog sysLog);

    SysLog selectById(Long id);

    int insertLog(SysLog sysLog);

    int deleteById(Long... id);//array
}
