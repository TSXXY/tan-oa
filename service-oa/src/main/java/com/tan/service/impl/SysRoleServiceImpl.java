package com.tan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.mapper.SysRoleMapper;
import com.tan.mapper.SysUserRoleMapper;
import com.tan.model.system.SysRole;
import com.tan.model.system.SysUserRole;
import com.tan.service.SysRoleService;
import com.tan.vo.system.AssginRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Tan
 * @description 针对表【sys_role(角色)】的数据库操作Service实现
 * @createDate 2023-04-12 13:47:41
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    private final SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public SysRoleServiceImpl(SysUserRoleMapper sysUserRoleMapper) {
        this.sysUserRoleMapper = sysUserRoleMapper;
    }

    @Override
    public Map<String, Object> findRoleByAdminId(Long userId) {
        //查询所有的角色
        List<SysRole> list = this.list();
        LambdaQueryWrapper<SysUserRole> sysRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysRoleLambdaQueryWrapper.eq(SysUserRole::getUserId, userId).select(SysUserRole::getRoleId);
        //或取用户角色关系
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(sysRoleLambdaQueryWrapper);
        //获取角色id
        List<Long> existRoleIdList = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());

        ArrayList<SysRole> sysRoles = new ArrayList<>();
        for (SysRole sysRole : list) {
            //检查id是否在角色中
            if (existRoleIdList.contains(sysRole.getId())) {
                sysRoles.add(sysRole);
            }
        }

        HashMap<String, Object> roleMap = new HashMap<>();
        roleMap.put("assginRoleList", sysRoles);
        roleMap.put("allRolesList", list);
        return roleMap;
    }

    @Transactional
    @Override
    public boolean doAssign(AssginRoleVo assginRoleVo) {
        LambdaQueryWrapper<SysUserRole> sysUserRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysUserRoleLambdaQueryWrapper.eq(SysUserRole::getUserId,assginRoleVo.getUserId());
        int delete = sysUserRoleMapper.delete(sysUserRoleLambdaQueryWrapper);
        if (delete!=0){
            for (Long roleId : assginRoleVo.getRoleIdList()) {
                if (ObjectUtils.isEmpty(roleId)) continue;
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(assginRoleVo.getUserId());
                sysUserRole.setRoleId(roleId);
                sysUserRoleMapper.insert(sysUserRole);
            }
            return true;
        }
        return false;
    }
}




