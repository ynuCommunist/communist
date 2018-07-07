package com.ynu.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 10:17 2018/7/7
 */
@Data
public class NewsDTO {

//    @ApiModelProperty(value = "新闻唯一ID", name = "id")
    private String id;

//    @ApiModelProperty(value = "标题", name = "title")
    private String title;

//    @ApiModelProperty(value = "摘要", name = "summary")
    private String summary;

//    @ApiModelProperty(value = "图片", name = "homepageImage")
    private MultipartFile homepageImage;

//    @ApiModelProperty(value = "内容", name = "content")
    private String content;

//    @ApiModelProperty(value = "阅读量", name = "readingVolume")
    private String readingVolume;

//    @ApiModelProperty(value = "作者", name = "author")
    private String author;

//    @ApiModelProperty(value = "新闻发布者ID",name = "newsPublisherId")
    private String newsPublisherId;

//    @ApiModelProperty(value = "新闻发布者", name = "newsPublisher")
    private String newsPublisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
//    @ApiModelProperty(value = "发表日期", name = "publicationTime")
    private Date publicationTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
//    @ApiModelProperty(value = "最后更新日期", name = "updateTime")
    private Date updateTime;
}
