package com.ynu.demo.repository;

import com.ynu.demo.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:08 2018/7/5
 */
public interface NewsRepository extends JpaRepository<News,String> {

    /*新闻的添加*/
    News save(News news);

    /*新闻的删除*/
    void deleteById(String id);

    /*新闻的修改*/


    /*新闻的查找*/
    Optional<News> findById(String id);

    Page<News> findAll(Pageable pageable);

    Page<News> findByTitleLikeOrContentLikeOrSummaryLike(String str1, String str2 , String str3,Pageable pageable);

    Page<News> findByTitleLike(String title ,Pageable pageable);

    Page<News> findByAuthorLike(String author ,Pageable pageable);

    Page<News> findByPublicationTimeLike(String date ,Pageable pageable);

}
