package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.system.SysPost;
import com.tan.service.SysPostService;
import com.tan.mapper.SysPostMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【sys_post(岗位信息表)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:38
*/
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost>
    implements SysPostService{

}




