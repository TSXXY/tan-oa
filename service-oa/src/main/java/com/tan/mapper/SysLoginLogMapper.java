package com.tan.mapper;

import com.tan.model.system.SysLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【sys_login_log(系统访问记录)】的数据库操作Mapper
* @createDate 2023-04-12 13:47:29
* @Entity com.tan.domain.SysLoginLog
*/
@Mapper
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

}




