package com.ynu.demo.repository;

import com.ynu.demo.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:19 2018/6/26
 */
public interface UpdRepository extends JpaRepository<PersonData,Integer> {

}
