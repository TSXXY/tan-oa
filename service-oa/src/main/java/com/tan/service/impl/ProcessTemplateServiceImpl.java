package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.process.ProcessTemplate;
import com.tan.service.ProcessTemplateService;
import com.tan.mapper.ProcessTemplateMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【oa_process_template(审批模板)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:20
*/
@Service
public class ProcessTemplateServiceImpl extends ServiceImpl<ProcessTemplateMapper, ProcessTemplate>
    implements ProcessTemplateService {

}




