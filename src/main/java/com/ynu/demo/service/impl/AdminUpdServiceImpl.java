package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.exception.MyException;
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
        BeanUtils.copyProperties(personDataDTO,personData);
        if(multipartFile != null){
            /*更新图片 直接覆盖原图片*/
            String contentType = multipartFile.getContentType();
            if (!contentType.contains("jpeg") && !contentType.contains("jpg") && !contentType.contains("png")) {
                //图片格式不对
                throw new MyException(ResultEnum.IMAGE_FORM_ERROR);
            }
            try {
                personData.setPhoto(ImageUtil.savePersonImage(personDataDTO.getPhoto(),personDataDTO.getId()));
            } catch (IOException e) {
                throw new MyException(ResultEnum.ERROR);
            }
        }else {
            /*不更新图片 保存原来图片存储位置*/
            String photo = addRepository.findById(personDataDTO.getId()).get().getPhoto();
            personData.setPhoto(photo);
        }

        addRepository.save(personData);
    }
}
