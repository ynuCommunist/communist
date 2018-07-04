package com.ynu.demo.repository;

import com.ynu.demo.entity.PersonData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FindRepository extends JpaRepository<PersonData,Integer> {

    /*通过id查询*/
    Optional<PersonData> findById(Integer id);

    /*通过名字精确查询*/
    Page<PersonData> findByName(String name, Pageable pageable);

    /*通过名字模糊查询*/
    Page<PersonData> findByNameLike(String name, Pageable pageable);

    /*通过当前所在城市精确查询返回分组信息*/
    Page<PersonData> queryByCity(String name, Pageable pageable);

    /*通过当前所在城市模糊查询返回分组信息*/
    Page<PersonData> queryByCityLike(String name, Pageable pageable);

    /*通过性别精确查询*/
    Page<PersonData> findBySex(String sex, Pageable pageable);

    /*通过性别模糊查询*/
    Page<PersonData> findBySexLike(String sex, Pageable pageable);

    /*通过生日精确查询*/
    Page<PersonData> findByBirthday(String birthday, Pageable pageable);

    /*通过生日模糊查询*/
    Page<PersonData> findByBirthdayLike(String birthday, Pageable pageable);

    /*通过民族精确查询*/
    Page<PersonData> findByNationality (String nationality, Pageable pageable);

    /*通过民族模糊查询*/
    Page<PersonData> findByNationalityLike (String nationality, Pageable pageable);

    /*通过籍贯精确查询*/
    Page<PersonData> findByNativePlace (String nativePlace, Pageable pageable);

    /*通过籍贯模糊查询*/
    Page<PersonData> findByNativePlaceLike (String nativePlace, Pageable pageable);

    /*通过婚姻状况查询*/
    Page<PersonData> findByMarryStatus (String marryStatus, Pageable pageable);

    /*通过入党时间精确查询*/
    List<PersonData> findByTimeForJoinCommunistParty (String timeForJoinCommunistParty);

    /*通过入党时间模糊查询*/
    List<PersonData> findByTimeForJoinCommunistPartyLike (String timeForJoinCommunistParty);

    /*通过转正时间精确查询*/
    List<PersonData> findByTimeForBecomeFull (String timeForBecomeFull);

    /*通过转正时间模糊查询*/
    List<PersonData> findByTimeForBecomeFullLike (String timeForBecomeFull);

    /*通过参加工作时间精确查询*/
    List<PersonData> findByTimeForWorking (String timeForWorking);

    /*通过参加工作时间模糊查询*/
    List<PersonData> findByTimeForWorkingLike (String timeForWorking);

    /*通过身份证号码查询*/
    List<PersonData> findByIdCard (String IDcard);

    /*通过入党时所在支部精确查询*/
    List<PersonData> findByWhereBeforeJoinCommunistParty (String beforeJoinCommunistParty);

    /*通过入党时所在支部模糊查询*/
    List<PersonData> findByWhereBeforeJoinCommunistPartyLike (String beforeJoinCommunistParty);

    /*通过入党介绍人精确查询*/
    List<PersonData> findByIntroducer (String introducer);

    /*通过入党介绍人模糊查询*/
    List<PersonData> findByIntroducerLike (String introducer);

    /*通过学历学位精确查询*/
    Page<PersonData> findByAcademicDegree (String academicDegree, Pageable pageable);

    /*通过学历学位模糊查询*/
    Page<PersonData> findByAcademicDegreeLike (String academicDegree, Pageable pageable);

    /*通过毕业院校系及专业精确查询*/
    Page<PersonData> findByGraduation (String graduation, Pageable pageable);

    /*通过毕业院校系及专业模糊查询*/
    Page<PersonData> findByGraduationLike (String graduation, Pageable pageable);

    /*通过当前职业精确查询*/
    Page<PersonData> findByCurrentCareer (String currentCareer, Pageable pageable);

    /*通过当前职业模糊查询*/
    Page<PersonData> findByCurrentCareerLike (String currentCareer, Pageable pageable);

    /*通过家庭住址精确查询*/
    Page<PersonData> findByFamilyAddress (String familyAddress, Pageable pageable);

    /*通过家庭住址模糊查询*/
    Page<PersonData> findByFamilyAddressLike (String familyAddress, Pageable pageable);

    /*通过QQ号查询*/
    List<PersonData> findByQq (String qq);

    /*通过微信号查询*/
    List<PersonData> findByWechat (String wechat);

    Page<PersonData> findByCityLike(String name, Pageable pageable);

    Page<PersonData> findByNameLikeAndCityLike(String name,String city,Pageable pageable);


}
