package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.News;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.NewsRepository;
import com.ynu.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:45 2018/7/5
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void addNews(News news) {

        newsRepository.save(news);
    }

    @Override
    public void del(String id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void upd(News news) {
        newsRepository.save(news);
    }

    @Override
    public Page<News> findAll(Integer pageNum, Integer pageSize, String title,String sort, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page;
        if(title.equals("")){
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
        return optionalNews.get();
    }

    @Override
    public Page<News> findByTitle(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page = newsRepository.findByTitleLike(finding, pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }

    @Override
    public Page<News> findByAuthor(Integer pageNum, Integer pageSize, String finding, String sort ,String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<News> page = newsRepository.findByAuthorLike(finding,pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }

    @Override
    public Page<News> findByPublicationTime(Integer pageNum, Integer pageSize, String finding,String sort , String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);

        Page<News> page = newsRepository.findByPublicationTimeLike(finding,pageable);
        if(page.getContent()==null){
            throw new  MyException(ResultEnum.ERROR);
        }
        return page;
    }
}
