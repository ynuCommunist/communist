package com.ynu.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
@ApiModel("PersonData")
public class PersonData {
    /*每个党员唯一标识*/
    @Id
    @ApiModelProperty(value = "党员唯一标识",name = "id")
    private String id = "";

    /*姓名*/
    @ApiModelProperty(value = "姓名",name = "name")
    private String name;

    /*当前所在城市*/
    @ApiModelProperty(value = "所在城市",name = "city")
    private String city;

    /*个人照片*/
    @ApiModelProperty(value = "个人照片",name = "photo")
    private String photo;

    /*性别（规定0为女性，1为男性）*/
    @ApiModelProperty(value = "性别",name = "sex")
    private String sex;

    /*出生日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期",name = "birthday")
    private Date birthday;

    /*民族*/
    @ApiModelProperty(value = "国籍",name = "nationality")
    private String nationality;

    /*民族*/
    @ApiModelProperty(value = "民族",name = "nation")
    private String nation;

    /*籍贯*/
    @ApiModelProperty(value = "籍贯",name = "nativePlace")
    private String nativePlace;

    /*婚姻状况（0为未婚，1为已婚，2为离婚，3为丧偶）*/
    @ApiModelProperty(value = "婚姻状况",name = "marryStatus")
    private String marryStatus;

    /*入党时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "入党时间",name = "timeForJoinCommunistParty")
    private Date timeForJoinCommunistParty;

    /*转正时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "转正时间",name = "timeForBecomeFull")
    private Date timeForBecomeFull;

    /*参加工作时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "参加工作时间",name = "timeForWorking")
    private Date timeForWorking;

    /*身份证号码*/
    @ApiModelProperty(value = "身份证号码",name = "idCard")
    private String idCard;

    /*入党时所在支部*/
    @ApiModelProperty(value = "入党时所在支部",name = "whereBeforeJoinCommunistParty")
    private String whereBeforeJoinCommunistParty;

    /*入党介绍人*/
    @ApiModelProperty(value = "入党介绍人",name = "introducer")
    private String introducer;

    /*转入当前支部日期*/
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "转入当前支部日期",name = "timeForJoinThis")
    private Date timeForJoinThis;

    /*转出党支部名称*/
    @ApiModelProperty(value = "转出党支部名称",name = "nameBeforeJoin")
    private String nameBeforeJoin;

    /*现任党内职务*/
    @ApiModelProperty(value = "现任党内职务",name = "nowIncumbentPosition")
    private String nowIncumbentPosition;

    /*学历学位*/
    @ApiModelProperty(value = "学历学位",name = "academicDegree")
    private String academicDegree;

    /*毕业院校系及专业*/
    @ApiModelProperty(value = "毕业院校系及专业",name = "graduation")
    private String graduation;

    /*当前职业*/
    @ApiModelProperty(value = "当前职业",name = "currentCareer")
    private String currentCareer;

    /*现工作单位及职务*/
    @ApiModelProperty(value = "现工作单位及职务",name = "presentWorkingUnitsAndDuties")
    private String presentWorkingUnitsAndDuties;

    /*户籍所在地*/
    @ApiModelProperty(value = "户籍所在地",name = "registeredPermanentResidence")
    private String registeredPermanentResidence;

    /*家庭住址*/
    @ApiModelProperty(value = "家庭住址",name = "familyAddress")
    private String familyAddress;

    /*手机号码*/
    @ApiModelProperty(value = "手机号码",name = "phone")
    private String phone;

    /*QQ号*/
    @ApiModelProperty(value = "QQ",name = "qq")
    private String qq;

    /*微信号*/
    @ApiModelProperty(value = "微信号",name = "wechat")
    private String wechat;

    /*父母配偶子女有关情况*/
    @ApiModelProperty(value = "父母配偶子女有关情况",name = "familySituation")
    private String familySituation;

    /*申请转入内容*/
    @ApiModelProperty(value = "申请转入内容",name = "ApplicationForTransferToContent")
    private String ApplicationForTransferToContent;

    /*创建时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间",name = "createTime")
    private Date createTime;

    /*更新时间*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间",name = "updateTime")
    private Date updateTime;

    public PersonData() {
    }

}
