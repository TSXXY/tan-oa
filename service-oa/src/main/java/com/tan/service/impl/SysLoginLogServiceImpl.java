package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.system.SysLoginLog;
import com.tan.service.SysLoginLogService;
import com.tan.mapper.SysLoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【sys_login_log(系统访问记录)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:29
*/
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog>
    implements SysLoginLogService{

}




