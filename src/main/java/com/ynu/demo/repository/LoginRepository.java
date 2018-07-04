package com.ynu.demo.repository;

import com.ynu.demo.entity.UserRolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:04 2018/6/30
 */
public interface LoginRepository extends JpaRepository<UserRolePermissions,String> {

    UserRolePermissions findByUsername(String username);
}
