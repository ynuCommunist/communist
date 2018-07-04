package com.ynu.demo.controller.admin;

import com.ynu.demo.repository.FindRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:19 2018/6/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AddControllerTest {
    @Autowired
    private FindRepository repository;

    @Test
    public void save() {
    }
}