package com.ynu.demo.service.impl;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.service.AdminFindService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:35 2018/6/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonDataServiceImplTest {

    @Autowired
    private AdminFindService adminFindService;

    @Test
    public void findById() {
        PersonData personData = adminFindService.getById(1);
//        Assert.assertEquals(1,personData.getId());
    }
}