package com.kss.jt.system.service.impl;

import com.kss.jt.system.Dao.SysNoticeDao;
import com.kss.jt.system.domain.SysNotice;
import com.kss.jt.system.service.SysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysNoticeServiceImpl implements SysNoticeService {

    @Autowired
    private SysNoticeDao sysNoticeDao;

    @Override
    public SysNotice selectById(Long id) {
        return sysNoticeDao.selectById(id);
    }

    @Override
    public int updateNotice(SysNotice notice) {
        return sysNoticeDao.updateNotice(notice);
    }

    @Override
    public int insertNotice(SysNotice notice) {
        return sysNoticeDao.insertNotice(notice);
    }

    @Override
    public int deleteById(Long... id) {
        return sysNoticeDao.deleteById(id);
    }

    @Override
    public List<SysNotice> selectNotices(SysNotice notice) {
        return sysNoticeDao.selectNotices(notice);
    }
}
