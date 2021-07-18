package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysLog;
import com.kss.jt.system.service.SysLogService;
import com.kss.jt.system.web.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Log/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping("{id}")
    public JsonResult doSelectById (Long id) {
        return new JsonResult(sysLogService.selectById(id));
    }

    @DeleteMapping("{ids}")
    public JsonResult doDeleteById (Long...ids) {
        sysLogService.deleteById(ids);
        return new JsonResult("delete ok");
    }

    @GetMapping
    public JsonResult doSelectLogs(SysLog sysLog){
        return new JsonResult(
                PageUtil.startPage()//启动分页查询拦截
                        .doSelectPageInfo(()-> //分页查询日志信息
                                sysLogService.selectLogs(sysLog)
                        ));
    }


    /*无添加日志方法，用户不必看见的信息则不返回*/

}
