package com.ynu.demo.repository;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.entity.UserRolePermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:12 2018/7/3
 */
public interface UserRepository extends JpaRepository<PersonData,Integer> {

    /*通过名字模糊查询*/
    Page<PersonData> findByNameLike(String name, Pageable pageable);
    /*通过城市模糊查询*/
    Page<PersonData> findByCityLike(String name, Pageable pageable);
    /*通过姓名和城市模糊查询*/
    Page<PersonData> findByNameLikeAndCityLike(String name,String city,Pageable pageable);

    UserRolePermissions save(UserRolePermissions userRolePermissions);
}
