package com.ynu.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @Author: IceSource and QW
 * @Description: 中转文件
 * @Date: Created in 18:47 2018/7/4
 */
@Data
public class PersonDataDTO {
    /*每个党员唯一标识*/
    private String id = "";

    /*姓名*/
    private String name;

    /*当前所在城市*/
    private String city;

    /*个人照片*/
    private MultipartFile photo;

    /*性别（规定0为女性，1为男性）*/
    private String sex;

    /*出生日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date birthday;

    /*民族*/
    private String nationality;

    /*民族*/
    private String nation;

    /*籍贯*/
    private String nativePlace;

    /*婚姻状况（0为未婚，1为已婚，2为离婚，3为丧偶）*/
    private String marryStatus;

    /*入党时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date timeForJoinCommunistParty;

    /*转正时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date timeForBecomeFull;

    /*参加工作时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date timeForWorking;

    /*身份证号码*/
    private String idCard;

    /*入党时所在支部*/
    private String whereBeforeJoinCommunistParty;

    /*入党介绍人*/
    private String introducer;

    /*转入当前支部日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date timeForJoinThis;

    /*转出党支部名称*/
    private String nameBeforeJoin;

    /*现任党内职务*/
    private String nowIncumbentPosition;

    /*学历学位*/
    private String academicDegree;

    /*毕业院校系及专业*/
    private String graduation;

    /*当前职业*/
    private String currentCareer;

    /*现工作单位及职务*/
    private String presentWorkingUnitsAndDuties;

    /*户籍所在地*/
    private String registeredPermanentResidence;

    /*家庭住址*/
    private String familyAddress;

    /*手机号码*/
    private String phone;

    /*QQ号*/
    private String qq;

    /*微信号*/
    private String wechat;

    /*父母配偶子女有关情况*/
    private String familySituation;

    /*申请转入内容*/
    private String ApplicationForTransferToContent;

    /*创建时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /*更新时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public PersonDataDTO() {
    }

    public PersonDataDTO(String id, String name, String city, MultipartFile photo, String sex, Date birthday, String nationality, String nation, String nativePlace, String marryStatus, Date timeForJoinCommunistParty, Date timeForBecomeFull, Date timeForWorking, String idCard, String whereBeforeJoinCommunistParty, String introducer, Date timeForJoinThis, String nameBeforeJoin, String nowIncumbentPosition, String academicDegree, String graduation, String currentCareer, String presentWorkingUnitsAndDuties, String registeredPermanentResidence, String familyAddress, String phone, String qq, String wechat, String familySituation, String applicationForTransferToContent, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.photo = photo;
        this.sex = sex;
        this.birthday = birthday;
        this.nationality = nationality;
        this.nation = nation;
        this.nativePlace = nativePlace;
        this.marryStatus = marryStatus;
        this.timeForJoinCommunistParty = timeForJoinCommunistParty;
        this.timeForBecomeFull = timeForBecomeFull;
        this.timeForWorking = timeForWorking;
        this.idCard = idCard;
        this.whereBeforeJoinCommunistParty = whereBeforeJoinCommunistParty;
        this.introducer = introducer;
        this.timeForJoinThis = timeForJoinThis;
        this.nameBeforeJoin = nameBeforeJoin;
        this.nowIncumbentPosition = nowIncumbentPosition;
        this.academicDegree = academicDegree;
        this.graduation = graduation;
        this.currentCareer = currentCareer;
        this.presentWorkingUnitsAndDuties = presentWorkingUnitsAndDuties;
        this.registeredPermanentResidence = registeredPermanentResidence;
        this.familyAddress = familyAddress;
        this.phone = phone;
        this.qq = qq;
        this.wechat = wechat;
        this.familySituation = familySituation;
        ApplicationForTransferToContent = applicationForTransferToContent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
