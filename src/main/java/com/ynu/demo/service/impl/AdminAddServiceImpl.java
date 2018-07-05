package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.FindRepository;
import com.ynu.demo.service.AdminAddService;
import com.ynu.demo.utils.ImageUtil;
import com.ynu.demo.utils.KeyUtil;
import com.ynu.demo.utils.TranferUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    public PersonData add(PersonDataDTO personDataDTO) {
        MultipartFile multipartFile = personDataDTO.getPhoto();
        if (multipartFile == null) {
            //图片为空
            throw new MyException(ResultEnum.IMAGE_ERROR);
        }
        String contentType = multipartFile.getContentType();
        log.info(contentType);
        if (!contentType.contains("jpeg") && !contentType.contains("jpg") && !contentType.contains("png")) {
            //图片格式不对
            throw new MyException(ResultEnum.IMAGE_FORM_ERROR);
        }
        personDataDTO.setId(KeyUtil.getUniqueKey());

        PersonData personData = TranferUtils.changeToPersonData(personDataDTO);
        return findRepository.save(personData);
    }
}
