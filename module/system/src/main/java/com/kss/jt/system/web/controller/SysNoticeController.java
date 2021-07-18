package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysNotice;
import com.kss.jt.system.service.SysNoticeService;
import com.kss.jt.system.web.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Notice/")
public class SysNoticeController {

    @Autowired
    private SysNoticeService sysNoticeService;

    @PostMapping
    public JsonResult doInsertNotice(@RequestBody SysNotice notice){
        sysNoticeService.insertNotice(notice);
        return new JsonResult("insert ok");
    }

    @PutMapping
    public JsonResult doUpdateNotice(@RequestBody SysNotice notice){
        sysNoticeService.updateNotice(notice);
        return new JsonResult("update ok");
    }

    @DeleteMapping("{id}")
    public JsonResult doDeleteById(@PathVariable Long ...id){
        sysNoticeService.deleteById(id);
        return new JsonResult("delete ok");
    }

    @GetMapping("{id}")
    public JsonResult doSelectById(@PathVariable Long id) {
        return new JsonResult(sysNoticeService.selectById(id));
    }


    @GetMapping
    public JsonResult doSelectNotices(SysNotice sysNotice){
        return new JsonResult(PageUtil.startPage()//启动分页拦截器
                .doSelectPageInfo(()->{//执行查询业务
                    sysNoticeService.selectNotices(sysNotice); }));
    }

}
