package com.tan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tan.model.base.BaseEntity;
import com.tan.model.system.SysUser;
import com.tan.result.Result;
import com.tan.service.SysUserService;
import com.tan.vo.system.SysUserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    private SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation("用户条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result getUserByPage(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysUserQueryVo sysUserQueryVo){
        Page<SysUser> sysUserPage = new Page<>(page, limit);
        LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        String keyword = sysUserQueryVo.getKeyword();
        String createTimeBegin = sysUserQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysUserQueryVo.getCreateTimeEnd();
        if (StringUtils.hasText(keyword)) {
            sysUserLambdaQueryWrapper.like(SysUser::getUsername,keyword);
        }
        if (StringUtils.hasText(createTimeBegin)) {
            sysUserLambdaQueryWrapper.like(BaseEntity::getCreateTime,createTimeBegin);
        }
        if (StringUtils.hasText(createTimeEnd)) {
            sysUserLambdaQueryWrapper.like(BaseEntity::getCreateTime,createTimeEnd);
        }

        Page<SysUser> userPage = sysUserService.page(sysUserPage, sysUserLambdaQueryWrapper);
        return Result.ok(userPage);


    }

    @ApiOperation("获取用户")
    @GetMapping("/getUser/{id}")
    public Result getUserById(@PathVariable Long id){
        if (ObjectUtils.isEmpty(id)){
            return Result.error("id不能为空");
        }
        SysUser byId = sysUserService.getById(id);
        if (ObjectUtils.isEmpty(byId)) {
            return Result.ok("用户不存在");
        }
        return Result.ok(byId);
    }

    @ApiOperation("添加用户")
    @PostMapping("saveUser")
    public Result saveUser(@RequestBody SysUser sysUser){
        if (ObjectUtils.isEmpty(sysUser)) {
           return Result.error();
        }
        boolean save = sysUserService.save(sysUser);
        if (save){
           return Result.ok("添加成功");
        }
        return Result.error();
    }

    @ApiOperation("修改用户")
    @PutMapping("updateUserById")
    public Result updateUser(@RequestBody SysUser sysUser){
        if (ObjectUtils.isEmpty(sysUser.getId())) {
            return Result.error("id不能为空");
        }
        boolean b = sysUserService.updateById(sysUser);
        if (b){
           return Result.ok();
        }
        return Result.error();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("deleteUser")
    public Result deleteUser(@RequestBody List<Long> ids){
        if (ids.isEmpty()) {
           return Result.error("传入了不正确的参数");
        }
        boolean b = sysUserService.removeByIds(ids);
        if (b) {
           return Result.ok("删除成功");
        }

        return Result.error("删除失败");
    }


}
