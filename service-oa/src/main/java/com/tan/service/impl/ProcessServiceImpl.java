package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.process.Process;
import com.tan.service.ProcessService;
import com.tan.mapper.ProcessMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【oa_process(审批类型)】的数据库操作Service实现
* @createDate 2023-04-12 13:46:45
*/
@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process>
    implements ProcessService {

}




