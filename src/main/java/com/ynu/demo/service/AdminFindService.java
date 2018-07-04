package com.ynu.demo.service;

import com.ynu.demo.dto.array;
import com.ynu.demo.entity.PersonData;
import org.springframework.data.domain.Page;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:30 2018/6/25
 */
public interface AdminFindService {
    /*查找全部*/
    Page<PersonData> getList(Integer pageNum, Integer pageSize, String title, String city, String sort ,String sortBy);

    /*根据ID查找*/
    PersonData getById(String finding);

    /*根据姓名查找*/
    Page<PersonData> getListByName(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据所在城市查找*/
    Page<PersonData> getGroupByCity(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据性别查找*/
    Page<PersonData> getListBySex(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy);

    /*根据国籍查找*/
    Page<PersonData> getListByNationality(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据民族查找*/
    Page<PersonData> getListByNation(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据籍贯查找*/
    Page<PersonData> getListByNativePlace(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据婚姻状况查找*/
    Page<PersonData> getListByMarryStatus(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy);

    /*根据家庭地址查找*/
    Page<PersonData> getListByFamilyAddress(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据毕业院校系及专业查找*/
    Page<PersonData> getListByGraduation(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*根据学历学位查找*/
    Page<PersonData> getListByAcademicDegree(Integer pageNum, Integer pageSize, String finding, boolean isAccurate,String sort ,String sortBy);

    /*返回MAP，key为城市，value为该城市党员数量*/
    array[] findAllGroupByCity();

}
