package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.system.SysMenu;
import com.tan.service.SysMenuService;
import com.tan.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【sys_menu(菜单表)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:32
*/
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>
    implements SysMenuService{

}




