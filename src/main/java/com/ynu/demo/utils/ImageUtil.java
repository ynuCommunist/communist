package com.ynu.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 18:05 2018/7/4
 */
@Slf4j
@Component
public class ImageUtil {


    public static String ImageUrl;
    @Value("${ImageUrl}")
    public void setImageUrl(String imageUrl){
        ImageUrl = imageUrl;
    }

    public static String ImageLocation;
    @Value("${ImageLocation}")
    public void setImageLocation(String imageLocation){
        ImageLocation = imageLocation;
    }

    public static String NewsImageUrl;
    @Value("${NewsImageUrl}")
    public void setNewsImageUrl(String newsImageUrl){
        NewsImageUrl = newsImageUrl;
    }

    public static String NewsImageLocation;
    @Value("${NewsImageLocation}")
    public void setNewsImageLocation(String newsImageLocation){
        NewsImageLocation = newsImageLocation;
    }

    public static String savePersonImage(MultipartFile multipartFile, String fileName) throws IOException {
        String totalPath = ImageLocation + fileName + ".png";
        String HttpPath = ImageUrl + fileName + ".png";
        log.info("图片存储地址:" + totalPath);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(totalPath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return HttpPath;
    }

    public static String saveImgs(MultipartFile[] multipartFile, String fileName) throws IOException {
        String allHttpPath = "";
        for (int i = 0; i < multipartFile.length; i++) {
            File file = new File(NewsImageLocation + fileName + File.separator);
            if(!file.exists()){
                file.mkdirs();
            }
            String totalPath = NewsImageLocation + fileName + File.separator + i + ".png";
            String HttpPath = NewsImageUrl + fileName + File.separator + i + ".png";
            log.info("图片存储地址:" + totalPath);
            FileInputStream fileInputStream = (FileInputStream) multipartFile[i].getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(totalPath));
            byte[] bs = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bs)) != -1) {
                bos.write(bs, 0, len);
            }
            bos.flush();
            bos.close();
            allHttpPath += HttpPath+";";
        }
        log.info(allHttpPath);
        return allHttpPath;
    }

    public static String saveNewsImage(MultipartFile multipartFile) throws IOException {
        String key = KeyUtil.getUniqueKey();
        String totalPath = NewsImageLocation + key + ".png";
        String HttpPath = NewsImageUrl + key + ".png";
        log.info("图片存储地址:" + totalPath);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(totalPath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return HttpPath;
    }

    public static String saveNewsImage(MultipartFile multipartFile, String fileName) throws IOException {
        String totalPath = NewsImageLocation +"HomepageImage\\"+ fileName + ".png";
        String HttpPath = NewsImageUrl +"HomepageImage/"+ fileName + ".png";
        log.info("图片存储地址:" + totalPath);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(totalPath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return HttpPath;
    }


}
