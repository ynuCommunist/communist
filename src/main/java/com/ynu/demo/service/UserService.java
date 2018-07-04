package com.ynu.demo.service;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.entity.UserRolePermissions;
import org.springframework.data.domain.Page;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:10 2018/7/3
 */
public interface UserService {
    /*查找全部*/
    Page<PersonData> getList(Integer pageNum, Integer pageSize, String title, String city, String sort , String sortBy);

    UserRolePermissions save(UserRolePermissions userRolePermissions);
}
