package com.kss.jt.system.Dao;

import com.kss.jt.system.domain.SysNotice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysNoticeDao {
    SysNotice selectById(Long id);
    int updateNotice(SysNotice notice);
    int insertNotice(SysNotice notice);
    int deleteById(Long ...id);
    List<SysNotice> selectNotices(SysNotice notice);
}
