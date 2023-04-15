package com.tan.service;

import com.tan.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tan.vo.system.AssginRoleVo;

import java.util.Map;

/**
* @author Tan
* @description 针对表【sys_role(角色)】的数据库操作Service
* @createDate 2023-04-12 13:47:41
*/
public interface SysRoleService extends IService<SysRole> {

    Map<String, Object> findRoleByAdminId(Long userId);

    boolean doAssign(AssginRoleVo assginRoleVo);
}
