package com.ynu.demo.utils;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.PersonDataDTO;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.exception.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:38 2018/7/3
 */
public class TranferUtils {

    public static String ArrayToString(String[] arrays){
        String result = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            result = result + "," + arrays[i];
        }
        return result;
    }

    public static String[] ArrayToString(String str){
        String[] result = str.split(",");
        return result;
    }

    public static PersonDataDTO changeToPersonDataDTO(PersonData personData){
        PersonDataDTO personDataDTO = new PersonDataDTO();
        BeanUtils.copyProperties(personData,personDataDTO);
//        personDataDTO.setPhoto();
        return personDataDTO;
    }

    public static PersonData changeToPersonData(PersonDataDTO personDataDTO){
        PersonData personData = new PersonData();
        BeanUtils.copyProperties(personDataDTO,personData);
        try {
            personData.setPhoto(ImageUtil.saveImg(personDataDTO.getPhoto(),personDataDTO.getId()));
        } catch (IOException e) {
            throw new MyException(ResultEnum.ERROR);
        }
        return personData;
    }
}
