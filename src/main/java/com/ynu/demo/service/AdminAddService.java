package com.ynu.demo.service;

import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:29 2018/6/26
 */
public interface AdminAddService {

    PersonData add(PersonDataDTO personDataDTO);
}
