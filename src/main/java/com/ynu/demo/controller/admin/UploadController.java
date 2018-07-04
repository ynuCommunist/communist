package com.ynu.demo.controller.admin;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.utils.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 17:25 2018/7/4
 */
@RestController
@Slf4j
public class UploadController {
    @PutMapping("/img/upload")
    public String uploadImg(@RequestParam("image-file") MultipartFile multipartFile)  {
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            //图片为空
            throw new MyException(ResultEnum.ERROR);
        }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
            //图片格式不对
            throw new MyException(ResultEnum.ERROR);
        }
        String root_fileName = multipartFile.getOriginalFilename();
        log.info("上传图片:图片{},类型{}", root_fileName, contentType);
        String file_name = null;
        try {
            file_name = ImageUtil.saveImg(multipartFile,"1");
            return file_name;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
