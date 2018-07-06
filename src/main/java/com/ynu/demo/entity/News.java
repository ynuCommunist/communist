package com.ynu.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:59 2018/7/5
 */
@Entity
@Data
@ApiModel("News")
public class News {
    @Id
    @ApiModelProperty(value = "新闻唯一ID",name = "id")
    private String id;

    @ApiModelProperty(value = "标题",name = "title")
    private String title;

    @ApiModelProperty(value = "摘要",name = "summary")
    private String summary;

    @ApiModelProperty(value = "图片数量",name = "imageAmount")
    private String imageAmount;

    @ApiModelProperty(value = "图片",name = "image")
    private String image;

    @ApiModelProperty(value = "内容",name = "content")
    private String content;

    @ApiModelProperty(value = "作者",name = "author")
    private String author;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发表日期",name = "publicationDate")
    private String publicationTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发表日期",name = "publicationDate")
    private String updateTime;
}
