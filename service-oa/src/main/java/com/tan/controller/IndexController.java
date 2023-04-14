package com.tan.controller;

import com.tan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api("后台登录管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/system/index")
public class IndexController {

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "admin");
        return Result.ok(map);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result info() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
