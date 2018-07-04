package com.ynu.demo.repository;

import com.ynu.demo.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:18 2018/6/26
 */
public interface AddRepository extends JpaRepository<PersonData,Integer> {
    /*储存信息*/
    PersonData save(PersonData personData);

}
