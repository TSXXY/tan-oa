package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.system.SysUser;
import com.tan.service.SysUserService;
import com.tan.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:46
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




