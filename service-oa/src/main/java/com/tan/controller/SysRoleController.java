package com.tan.controller;

import com.tan.result.Result;
import com.tan.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @GetMapping("/findAll")
    public Result findAll() {
        return Result.ok(sysRoleService.list());
    }
}