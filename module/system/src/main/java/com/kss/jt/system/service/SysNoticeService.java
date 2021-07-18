package com.kss.jt.system.service;

import com.kss.jt.system.domain.SysNotice;

import java.util.List;

public interface SysNoticeService {
    SysNotice selectById(Long id);
    int updateNotice(SysNotice notice);
    int insertNotice(SysNotice notice);
    int deleteById(Long ...id);
    List<SysNotice> selectNotices(SysNotice notice);
}
