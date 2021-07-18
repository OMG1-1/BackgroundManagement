package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysRole;
import com.kss.jt.system.service.SysRoleService;
import com.kss.jt.system.web.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @GetMapping("checkRoles")
    public JsonResult doSelectCheckRoles(){
        return new JsonResult(sysRoleService.selectCheckRoles());
    }

    @GetMapping("{id}")
    public JsonResult doSelectById(@PathVariable Integer id){
        return new JsonResult(sysRoleService.selectById(id));
    }

    @PutMapping
    public JsonResult doUpdateRole(@RequestBody SysRole entity){
        sysRoleService.updateRole(entity);
        return new JsonResult("update ok");
    }
    @PostMapping
    public JsonResult doInsertRole(@RequestBody SysRole entity){
        sysRoleService.insertRole(entity);
        return new JsonResult("save ok");
    }

    @GetMapping
    public JsonResult doSelectRoles(SysRole entity){
        return new JsonResult(PageUtil.startPage()
                .doSelectPageInfo(()->{
                    sysRoleService.selectRoles(entity);
                }));
    }

}
