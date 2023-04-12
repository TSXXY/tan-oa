package com.tan;

import com.tan.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MySpringBootTest {

    private SysRoleService sysRoleService;

    @Autowired
    public MySpringBootTest(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Test
    public void getAll() {
        System.out.println(sysRoleService.list());
    }

    @Test
    public void delete(){
        sysRoleService.removeById(1);
    }

}
