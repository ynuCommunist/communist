package com.ynu.demo.service;

import com.ynu.demo.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:38 2018/7/5
 */
public interface NewsService {
    /*放新闻*/
    void addNews(News news);

    /*删新闻*/
    void del(String id);

    /*改新闻*/
    void upd(News news);

    /*找新闻*/
    Page<News> findAll(Integer pageNum, Integer pageSize, String title,String sort, String sortBy);

    News findById(String id);

    Page<News> findByTitle(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy);

    Page<News> findByAuthor(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy);

    Page<News> findByPublicationTime(Integer pageNum, Integer pageSize, String finding,String sort , String sortBy);
}
