package com.ynu.demo.service.impl;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.FindRepository;
import com.ynu.demo.service.AdminAddService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:34 2018/6/26
 */
@Service
@Slf4j
public class AdminAddServiceImpl implements AdminAddService {
    @Autowired
    private FindRepository findRepository;

    @Override
    public PersonData add(PersonData personData) {
        if(findRepository.findById(personData.getId()).isPresent()){
            throw new RuntimeException("id已存在");
        }
        personData.setId(String.valueOf((int)System.currentTimeMillis()) + String.valueOf((int)(Math.random()*9+1)*100));
        return findRepository.save(personData);
    }
}
