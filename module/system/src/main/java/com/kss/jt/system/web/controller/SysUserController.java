package com.kss.jt.system.web.controller;

import com.kss.jt.domain.JsonResult;
import com.kss.jt.system.domain.SysUser;
import com.kss.jt.system.service.SysUserService;
import com.kss.jt.system.web.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询用户信息
     * @Param entity SysUser 根据传入的字段进行检索
     * @return JsonResult 返回自定义响应信息的对象 通过*/
    @GetMapping
    public JsonResult doSelectUsers(SysUser entity){
        return new JsonResult(
                PageUtil.startPage().doSelectPageInfo(()-> sysUserService.findUsers(entity)));
    }
    @PostMapping
    public JsonResult doInsertUser(@RequestBody SysUser entity){
        sysUserService.saveUser(entity);
        return new JsonResult("save ok");
    }

    @GetMapping("{id}")
    public JsonResult doSelectById(@PathVariable Integer id){
        return new JsonResult(sysUserService.findById(id));
    }

    @PutMapping
    public JsonResult doUpdateUser(@RequestBody SysUser entity){
        sysUserService.updateUser(entity);
        return new JsonResult("update ok");
    }

    @PatchMapping("{id}/{valid}")
    //少量数据的更新可使用Patch请求,当然使用put也可以.
    public JsonResult doValidById(@PathVariable Integer id,
                                  @PathVariable Integer valid){
        sysUserService.validById(id,valid);//update
        return new JsonResult("update ok");
    }

}
