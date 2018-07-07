package com.ynu.demo.service.impl;

import com.ynu.demo.repository.DelRepository;
import com.ynu.demo.service.AdminDelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:00 2018/6/26
 */
@Service
@Slf4j
public class AdminDelServiceImpl implements AdminDelService {

    @Value("${PersonImageLocation}")
    private String PersonImageLocation;


    @Autowired
    private DelRepository delRepository;

    @Override
    public void delById(String id) {
        delRepository.deleteById(id);
        File file = new File(PersonImageLocation+id+".png");
        file.delete();
    }
}
