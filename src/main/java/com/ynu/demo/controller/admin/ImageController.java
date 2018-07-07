package com.ynu.demo.controller.admin;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.utils.ImageUtil;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 1:49 2018/7/7
 */
@RestController
@RequestMapping("/admin")
@Api(description = "管理员对图片操作接口")
public class ImageController {

    public static String NewsImageLocation;
    @Value("${NewsImageLocation}")
    public void setNewsImageLocation(String newsImageLocation){
        NewsImageLocation = newsImageLocation;
    }

    @PostMapping("/addImage")
    @ApiOperation(value = "添加图片")
    @CrossOrigin
    public ReturnResult uploadImage(@RequestParam("file") MultipartFile multipartFile){
        String HttpPath;
        try {
            HttpPath = ImageUtil.saveNewsImage(multipartFile);
        } catch (IOException e) {
            throw new MyException(ResultEnum.ERROR);
        }
        return ReturnResultUtil.success(HttpPath);
    }

    @PostMapping("/delImage")
    public ReturnResult delImage(@RequestParam("id") String id){
        File file = new File(NewsImageLocation + id +".png");
        file.delete();
        return ReturnResultUtil.success();
    }
}
