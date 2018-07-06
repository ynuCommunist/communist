package com.ynu.demo.service.impl;

import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.AddRepository;
import com.ynu.demo.repository.DelRepository;
import com.ynu.demo.service.AdminUpdService;
import com.ynu.demo.utils.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
    public void update(PersonDataDTO personDataDTO) {
        MultipartFile multipartFile = personDataDTO.getPhoto();
        PersonData personData = new PersonData();
        if(multipartFile != null){
            /*更新图片 直接覆盖原图片*/
            BeanUtils.copyProperties(personDataDTO,personData);
            try {
                personData.setPhoto(ImageUtil.saveImg(personDataDTO.getPhoto(),personDataDTO.getId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            /*不更新图片 保存原来图片存储位置*/
            String photo = addRepository.findById(personDataDTO.getId()).get().getPhoto();
            BeanUtils.copyProperties(personDataDTO,personData);
            personData.setPhoto(photo);
        }

        addRepository.save(personData);
    }
}
