package com.tan.mapper;

import com.tan.model.process.Process;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【oa_process(审批类型)】的数据库操作Mapper
* @createDate 2023-04-12 13:46:45
* @Entity com.tan.domain.OaProcess
*/
@Mapper
public interface ProcessMapper extends BaseMapper<Process> {

}




