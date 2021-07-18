package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysDept;
import com.kss.jt.system.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    public JsonResult doSelectDepts(){
        return new JsonResult(sysDeptService.selectDepts());
    }

    @GetMapping("treeNodes")
    public JsonResult doSelectZTreeNodes() {
        return new JsonResult(sysDeptService.selectDeptTreeNodes());
    }

    @PutMapping
    public JsonResult doUpdateDept(@RequestBody SysDept entity){
        sysDeptService.updateDept(entity);
        return new JsonResult("update ok");
    }

    @PostMapping
    public JsonResult doInsertDept(@RequestBody SysDept entity){
        sysDeptService.insertDept(entity);
        return new JsonResult("save ok");
    }





}
