package com.ynu.demo.service.impl;

import com.ynu.demo.entity.PersonData;
import com.ynu.demo.repository.FindRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:35 2018/6/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdminAddServiceImplTest {
    @Autowired
    private FindRepository findRepository;

    @Test
    @Transactional
    public void add() {
        PersonData personData = new PersonData();
        personData.setId(8);
        personData.setName("小狗");
        personData.setPhoto("http://...");
        personData.setSex("0");
        personData.setBirthday(new Date(1997-1900,11,30));
        personData.setNationality("汉族");
        personData.setNativePlace("昆明");
        personData.setMarryStatus("0");
        personData.setTimeForJoinCommunistParty(new Date());
        personData.setTimeForBecomeFull(new Date());
        personData.setTimeForWorking(new Date());
        personData.setIdCard("452527199712300001");
        personData.setWhereBeforeJoinCommunistParty("...");
        personData.setIntroducer("狗州");
        personData.setTimeForJoinThis(new Date());
        personData.setNameBeforeJoin("...");
        personData.setNowIncumbentPosition("...");
        personData.setAcademicDegree("...");
        personData.setGraduation("...");
        personData.setCurrentCareer("...");
        personData.setPresentWorkingUnitsAndDuties("...");
        personData.setRegisteredPermanentResidence("...");
        personData.setFamilyAddress("...");
        personData.setPhone("...");
        personData.setQq("...");
        personData.setWechat("...");
        personData.setCreateTime(new Date());
        personData.setUpdateTime(new Date());

        if(findRepository.findById(personData.getId()).isPresent()){
//            throw new RuntimeException("id已存在");
            log.info("id已存在");
        }else {
            log.info("ok");
        }
//        PersonData result = findRepository.save(personData);
//        Assert.assertNotNull(result);

    }
}