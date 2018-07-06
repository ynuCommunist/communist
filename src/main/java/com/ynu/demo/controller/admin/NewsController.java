package com.ynu.demo.controller.admin;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.News;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.NewsRepository;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.NewsService;
import com.ynu.demo.utils.ImageUtil;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 23:06 2018/7/5
 */
@RestController
@Slf4j
@RequestMapping("/admin/news")
@Api(description = "管理员新闻操作接口")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsRepository repository;

    @ApiOperation(value = "添加新闻")
    @PostMapping("/addOne")
    public ReturnResult addNews(@RequestParam("files")MultipartFile[] files) {
        List<String> urls = new ArrayList<>();
        log.info(String.valueOf(files.length));
        if (files.length == 0){
            throw new MyException(ResultEnum.ERROR);
        }


        try {
            ImageUtil.saveImgs(files,"test");
        } catch (IOException e) {
            throw new MyException(ResultEnum.ERROR);
        }
        return null;
    }

    @ApiOperation(value = "删除新闻")
    @GetMapping("/delOne")
    public ReturnResult delNews(@RequestParam("id") String id) {
        return null;
    }

    @ApiOperation(value = "更新新闻")
    @PostMapping("/updOne")
    public ReturnResult updNews(News news) {
        return null;
    }

    @ApiOperation(value = "通过ID找新闻")
    @GetMapping("/findById")
    public ReturnResult findById(@RequestParam("id") String id) {

        return ReturnResultUtil.success(newsService.findById(id));
    }

    @ApiOperation(value = "通过标题找新闻")
    @GetMapping("/findByTitle")
    public ReturnResult findByTitle(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam("finding") String finding,
                                    @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                    @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        Page<News> page = newsService.findByTitle(pageNum, pageSize, finding, sort, sortBy);
        return ReturnResultUtil.success(page);
    }

    @ApiOperation(value = "通过作者找新闻")
    @GetMapping("/findByAuthor")
    public ReturnResult findByAuthor(@RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("finding") String finding,
                                     @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                     @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        Page<News> page = newsService.findByAuthor(pageNum, pageSize, finding, sort, sortBy);
        return ReturnResultUtil.success(page);
    }

    @ApiOperation(value = "通过发表日期找新闻")
    @GetMapping("/findByPublicationTime")
    public ReturnResult findByPublicationTime(@RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("finding") String finding,
                                              @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                              @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        Page<News> page = newsService.findByPublicationTime(pageNum-1, pageSize, finding+"%", sort, sortBy);
        return ReturnResultUtil.success(page);
    }
}
