package com.tan.mapper;

import com.tan.model.process.ProcessTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【oa_process_template(审批模板)】的数据库操作Mapper
* @createDate 2023-04-12 13:47:20
* @Entity com.tan.domain.OaProcessTemplate
*/
@Mapper
public interface ProcessTemplateMapper extends BaseMapper<ProcessTemplate> {

}




