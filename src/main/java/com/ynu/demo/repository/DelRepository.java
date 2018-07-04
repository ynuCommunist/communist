package com.ynu.demo.repository;

import com.ynu.demo.entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:17 2018/6/26
 */
public interface DelRepository extends JpaRepository<PersonData,Integer> {
    /*通过id删除*/
    void deleteById(Integer id);
    /*通过id删除多条信息*/
    void deleteByIdIn(List<Integer> id);
}
