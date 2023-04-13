package com.tan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tan.model.wechat.Menu;
import com.tan.service.MenuService;
import com.tan.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author Tan
* @description 针对表【wechat_menu(菜单)】的数据库操作Service实现
* @createDate 2023-04-12 13:47:51
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {

}




