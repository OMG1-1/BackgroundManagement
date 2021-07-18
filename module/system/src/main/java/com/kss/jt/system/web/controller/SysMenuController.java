package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysMenu;
import com.kss.jt.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Menu/")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;
    @PutMapping
    public JsonResult doUpdateMenu(
            @RequestBody SysMenu menu){
        sysMenuService.updateMenu(menu);
        return new JsonResult("Update Ok");
    }

    @GetMapping("{id}")
    public JsonResult doSelectById(
            @PathVariable Integer id){
        return new
                JsonResult(sysMenuService.selectById(id));
    }

    @PostMapping
    public JsonResult doInsertMenu(
            @RequestBody SysMenu menu){
        sysMenuService.insertMenu(menu);
        return new JsonResult("Save OK");
    }

    @GetMapping("treeNodes")
    public JsonResult doSelectMenuTreeNodes(){
        return new JsonResult(
                sysMenuService.selectMenuTreeNodes());
    }

    @GetMapping
    public JsonResult doSelectMenus(){
        return new JsonResult(sysMenuService.selectMenus());
    }

}
