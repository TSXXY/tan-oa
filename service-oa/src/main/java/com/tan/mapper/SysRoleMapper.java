package com.tan.mapper;

import com.tan.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【sys_role(角色)】的数据库操作Mapper
* @createDate 2023-04-12 13:47:41
* @Entity com.tan.domain.SysRole
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}




