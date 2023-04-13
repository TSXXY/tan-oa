package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.process.ProcessRecord;
import com.tan.service.ProcessRecordService;
import com.tan.mapper.ProcessRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【oa_process_record(审批记录)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:16
*/
@Service
public class ProcessRecordServiceImpl extends ServiceImpl<ProcessRecordMapper, ProcessRecord>
    implements ProcessRecordService {

}




