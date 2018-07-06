package com.ynu.demo.service.impl;

import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.FindRepository;
import com.ynu.demo.service.AdminAddService;
import com.ynu.demo.utils.ImageUtil;
import com.ynu.demo.utils.TranferUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public PersonData add(PersonData personData,MultipartFile multipartFile) {
        if(findRepository.findById(personData.getId()).isPresent()){
            throw new RuntimeException("id已存在");
        }
        personData.setId(String.valueOf((int)System.currentTimeMillis()) + String.valueOf((int)(Math.random()*9+1)*100));
        String temp = "";
        try {
            temp = ImageUtil.saveImg(multipartFile,personData.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        personData.setPhoto(temp);
//        PersonData personData = TranferUtils.changeToPersonData(personDataDTO);
        return findRepository.save(personData);
    }
}
