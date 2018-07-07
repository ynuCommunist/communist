package com.ynu.demo.controller.admin;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.result.ReturnResult;
import com.ynu.demo.service.AdminFindService;
import com.ynu.demo.utils.ReturnResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:51 2018/6/24
 */
@RestController
@RequestMapping("/admin/find")
@Api(description = "管理员查询党员信息接口")
public class FindController {

    @Autowired
    private AdminFindService adminFindService;

    @ApiOperation(value = "查找所有党员")
    @GetMapping("/findall")
    public ReturnResult findAll(@RequestParam("pageNum") Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam(name = "title",required = false) String finding,
                                @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {

        return ReturnResultUtil.success(adminFindService.getList(pageNum-1, pageSize, finding, sort, sortBy));
    }

    @ApiOperation(value = "通过ID查找党员")
    @GetMapping("/findById")
    public ReturnResult findById(@RequestParam("finding") String finding) {

        return ReturnResultUtil.success(adminFindService.getById(finding));
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "通过姓名查找党员")
    public ReturnResult findByName(@RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("finding") String finding,
                                   @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                   @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                   @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByName(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @GetMapping("/findByCity")
    @ApiOperation(value = "通过城市查找党员")
    public ReturnResult getGroupByCity(@RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("finding") String finding,
                                   @RequestParam(name = "isAccurate", defaultValue = "true") boolean isAccurate,
                                   @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                   @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getGroupByCity(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @GetMapping("/findAllGroupByCity")
    @ApiOperation(value = "查找城市的党员数量")
    public ReturnResult findAllGroupByCity(){
        return ReturnResultUtil.success(adminFindService.findAllGroupByCity());
    }

    @GetMapping("/findBySex")
    @ApiOperation(value = "通过性别查找党员")
    public ReturnResult findBySex(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam("finding") String finding,
                                  @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListBySex(pageNum-1, pageSize, finding, sort, sortBy));
    }

    @ApiOperation(value = "通过国籍查找党员")
    @GetMapping("/findByNationality")
    public ReturnResult findByNationality(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("finding") String finding,
                                          @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                          @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                          @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByNationality(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @ApiOperation(value = "通过民族查找党员")
    @GetMapping("/findByNation")
    public ReturnResult findByNation(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("finding") String finding,
                                          @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                          @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                          @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByNation(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @ApiOperation(value = "通过籍贯查找党员")
    @GetMapping("/findByNativePlace")
    public ReturnResult findByNativePlace(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("finding") String finding,
                                          @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                          @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                          @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByNativePlace(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @ApiOperation(value = "通过婚姻状况查找党员")
    @GetMapping("/findByMarryStatus")
    public ReturnResult findByMarryStatus(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam("finding") String finding,
                                          @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                          @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByMarryStatus(pageNum-1, pageSize, finding, sort, sortBy));
    }

    @ApiOperation(value = "通过家庭地址查找党员")
    @GetMapping("/findByFamilyAddress")
    public ReturnResult findByFamilyAddress(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("finding") String finding,
                                            @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                            @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByFamilyAddress(pageNum-1, pageSize, finding, isAccurate, sort, sortBy));
    }

    @ApiOperation(value = "通过毕业院校系及专业查找党员")
    @GetMapping("/findByGraduation")
    public ReturnResult findByGraduation(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("finding") String finding,
                                         @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                         @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                         @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByGraduation(pageNum-1, pageSize, finding, isAccurate,sort, sortBy));
    }

    @ApiOperation(value = "通过学历学位查找党员")
    @GetMapping("/findByAcademicDegree")
    public ReturnResult findByAcademicDegree(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("finding") String finding,
                                             @RequestParam(name = "isAccurate", defaultValue = "true") Boolean isAccurate,
                                             @RequestParam(name = "sort", defaultValue = "ASC") String sort,
                                             @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
        return ReturnResultUtil.success(adminFindService.getListByAcademicDegree(pageNum-1, pageSize, finding, isAccurate,sort, sortBy));
    }

}
