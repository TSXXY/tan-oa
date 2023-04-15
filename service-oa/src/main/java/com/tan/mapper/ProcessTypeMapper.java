package com.tan.mapper;

import com.tan.model.process.ProcessType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【oa_process_type(审批类型)】的数据库操作Mapper
* @createDate 2023-04-12 13:47:23
* @Entity com.tan.domain.OaProcessType
*/
@Mapper
public interface ProcessTypeMapper extends BaseMapper<ProcessType> {

}




