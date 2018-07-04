package com.ynu.demo.service.impl;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.AddRepository;
import com.ynu.demo.repository.DelRepository;
import com.ynu.demo.service.AdminUpdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:44 2018/6/26
 */
@Service
@Slf4j
public class AdminUpdServiceImpl implements AdminUpdService {

    @Autowired
    private AddRepository addRepository;

    @Override
    public void update(PersonData personData) {
        addRepository.save(personData);
    }
}
