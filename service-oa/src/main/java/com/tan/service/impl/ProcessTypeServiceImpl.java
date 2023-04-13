package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.process.ProcessType;
import com.tan.service.ProcessTypeService;
import com.tan.mapper.ProcessTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【oa_process_type(审批类型)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:23
*/
@Service
public class ProcessTypeServiceImpl extends ServiceImpl<ProcessTypeMapper, ProcessType>
    implements ProcessTypeService {

}




