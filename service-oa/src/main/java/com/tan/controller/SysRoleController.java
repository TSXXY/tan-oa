package com.tan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tan.model.system.SysRole;
import com.tan.result.Result;
import com.tan.service.SysRoleService;
import com.tan.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result findAll() {
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo) {

        Page<SysRole> sysRolePage = new Page<>(page, limit);

        LambdaQueryWrapper<SysRole> sysRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        System.out.println(roleName);
        if (StringUtils.hasText(roleName)) {
            sysRoleLambdaQueryWrapper.like(SysRole::getRoleName, roleName);
        }

        Page<SysRole> rolePage = sysRoleService.page(sysRolePage, sysRoleLambdaQueryWrapper);
        return Result.ok(rolePage);
    }

    @ApiOperation("添加角色")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok("添加成功");
        }
        return Result.error();
    }

    @ApiOperation("跟据id查找角色")
    @GetMapping("/getRoleById")
    public Result getRoleById(@RequestParam Long id){
        SysRole role = sysRoleService.getById(id);
        if (!ObjectUtils.isEmpty(role)){
            return Result.ok(role);
        }
        return Result.error("不存在角色");
    }

    @ApiOperation("根据id修改角色")
    @PutMapping("/updateRole")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok("修改成功");
        }
        return Result.error();
    }

    @ApiOperation("根据id删除,可批量和单个删除")
    @DeleteMapping("/deleteRoleById")
    public Result deleteRoleById(@RequestBody List<Long> ids){
        boolean isSuccess = sysRoleService.removeByIds(ids);
        if (isSuccess) {
            return Result.ok("删除成功");
        }
        return Result.error();
    }
}
