package com.tan.mapper;

import com.tan.model.system.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Tan
* @description 针对表【sys_post(岗位信息表)】的数据库操作Mapper
* @createDate 2023-04-12 13:47:38
* @Entity com.tan.domain.SysPost
*/
@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {

}




