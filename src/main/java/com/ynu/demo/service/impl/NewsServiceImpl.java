package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.NewsDTO;
import com.ynu.demo.entity.News;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.NewsRepository;
import com.ynu.demo.service.NewsService;
import com.ynu.demo.utils.ImageUtil;
import com.ynu.demo.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:45 2018/7/5
 */
@Service
@Slf4j
public class NewsServiceImpl implements NewsService {

    @Value("${NewsImageLocation}")
    private String NewsImageLocation;

    @Value("${HomepageImageLocation}")
    private String HomepageImageLocation;

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void addNews(NewsDTO newsDTO) {
        /*设置唯一ID*/
        newsDTO.setId(KeyUtil.getUniqueKey());

        /*根据当前登录用户设置新闻发布人*/
        UserRolePermissions userRolePermissions = (UserRolePermissions) SecurityUtils.getSubject().getPrincipal();
        newsDTO.setNewsPublisherId(userRolePermissions.getId());
        newsDTO.setNewsPublisher(userRolePermissions.getUsername());

        /*设置发布时间*/
        newsDTO.setUpdateTime(new Date());

        /*将中间量NewsDTO转换为News*/
        News news = new News();
        BeanUtils.copyProperties(newsDTO,news);
        MultipartFile multipartFile = newsDTO.getHomepageImage();
        if(multipartFile != null){
            String contentType = multipartFile.getContentType();
            if (!contentType.contains("jpeg") && !contentType.contains("jpg") && !contentType.contains("png")) {
                //图片格式不对
                throw new MyException(ResultEnum.IMAGE_FORM_ERROR);
            }
            try {
                news.setHomepageImage(ImageUtil.saveNewsImage(newsDTO.getHomepageImage(),newsDTO.getId()));
            } catch (IOException e) {
                throw new MyException(ResultEnum.ERROR);
            }
        }

        newsRepository.save(news);
    }

    @Override
    public void delNews(String id) {
        /*将数据库中的信息删除*/
        newsRepository.deleteById(id);
        /*将本地的图片删除*/
        File file = new File(HomepageImageLocation + id + ".png");
        file.delete();
    }

    @Override
    public void updNews(NewsDTO newsDTO) {
        News news = new News();
        BeanUtils.copyProperties(newsDTO,news);
        MultipartFile multipartFile = newsDTO.getHomepageImage();
        if(multipartFile != null){
            /*更改图片*/
            String contentType = multipartFile.getContentType();
            if (!contentType.contains("jpeg") && !contentType.contains("jpg") && !contentType.contains("png")) {
                //图片格式不对
                throw new MyException(ResultEnum.IMAGE_FORM_ERROR);
            }
            try {
                news.setHomepageImage(ImageUtil.saveNewsImage(newsDTO.getHomepageImage(),newsDTO.getId()));
            } catch (IOException e) {
                throw new MyException(ResultEnum.ERROR);
            }
        }else {
            /*不更新图片 保存原来图片存储位置*/
            String photo = newsRepository.findById(newsDTO.getId()).get().getHomepageImage();
            news.setHomepageImage(photo);
        }
        newsRepository.save(news);
    }

    @Override
    public Page<News> findAll(Integer pageNum, Integer pageSize, String title,String sort, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page;
        if(title == null){
            page = newsRepository.findAll(pageable);
        }else {
            page = newsRepository.findByTitleLikeOrContentLike("%"+title+"%","%"+title+"%",pageable);
        }
        return page;
    }

    @Override
    public News findById(String id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if(!optionalNews.isPresent()){
            throw new MyException(ResultEnum.ERROR);
        }
        News news = optionalNews.get();
        return news;
    }

    @Override
    public Page<News> findByTitle(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page = newsRepository.findByTitleLike("%"+finding+"%", pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }

    @Override
    public Page<News> findByAuthor(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page = newsRepository.findByAuthorLike("%"+finding+"%",pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }

    @Override
    public Page<News> findByPublicationTime(Integer pageNum, Integer pageSize, String finding,String sort , String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);

        Page<News> page = newsRepository.findByPublicationTimeLike(finding+"%",pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }
}
