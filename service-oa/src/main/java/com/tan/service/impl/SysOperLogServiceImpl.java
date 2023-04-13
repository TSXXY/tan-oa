package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.system.SysOperLog;
import com.tan.service.SysOperLogService;
import com.tan.mapper.SysOperLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:35
*/
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog>
    implements SysOperLogService{

}




