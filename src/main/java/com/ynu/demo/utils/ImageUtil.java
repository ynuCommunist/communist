package com.ynu.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 18:05 2018/7/4
 */
@Slf4j
public class ImageUtil {

    public static String saveImg(MultipartFile multipartFile, String fileName) throws IOException {
        String totalPath = ".\\src\\main\\resources\\photo\\" + fileName + ".png";
        log.info("图片存储地址" + totalPath);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(totalPath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return totalPath;
    }

//    public static MultipartFile getImg(String totalPath){
//        MultipartFile multipartFile = ;
//    }123456789
}
