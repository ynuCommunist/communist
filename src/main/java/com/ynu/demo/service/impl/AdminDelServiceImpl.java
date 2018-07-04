package com.ynu.demo.service.impl;

import com.ynu.demo.repository.DelRepository;
import com.ynu.demo.service.AdminDelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:00 2018/6/26
 */
@Service
@Slf4j
public class AdminDelServiceImpl implements AdminDelService {

    @Autowired
    private DelRepository delRepository;

    @Override
    public void delById(Integer id) {
        delRepository.deleteById(id);
    }
}
