package com.ynu.demo.service.impl;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.FindRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 18:10 2018/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminFindServiceImplTest {
    @Autowired
    private FindRepository findRepository;

//    @Test
//    public void getList() {
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<PersonData> page = findRepository.findByNameLike("%张%",pageable);
//        for (int i = 0; i < page.getTotalElements() ; i++) {
//            log.info(page.getContent().get(i).getName());
//        }
//    }

    @Test
    public void getGroupByCity(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<PersonData> page = findRepository.queryByCityLike("%不%",pageable);
        for (int i = 0; i < page.getTotalElements() ; i++) {
            log.info(page.getContent().get(i).getName());
        }
    }

    @Test
    public void getList() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<PersonData> page = findRepository.findByNameLikeAndCityLike("%丘%", "%林%", pageable);
        for (int i = 0; i < page.getTotalElements(); i++) {
            log.info(page.getContent().get(i).getName());
        }
    }

    @Test
    public void findAllGroupByCity(){
        List<PersonData> list = findRepository.findAll();
        Map<String ,Integer> map = new HashMap<>();
        for (PersonData temp : list) {
            if(map.containsKey(temp.getCity())){
                map.put(temp.getCity(),map.get(temp.getCity())+1);
            }else {
                map.put(temp.getCity(),1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
//            entry.getKey() ;entry.getValue(); entry.setValue();
//            map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }
    }
}