package com.ynu.demo.repository;

import com.ynu.demo.entity.UserRolePermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:33 2018/7/3
 */
public interface UserRolePermissionsRepository extends JpaRepository<UserRolePermissions,String> {

    Page<UserRolePermissions> findAllByUsernameLikeAndRoleIs(String title, String role,Pageable pageable);


}
