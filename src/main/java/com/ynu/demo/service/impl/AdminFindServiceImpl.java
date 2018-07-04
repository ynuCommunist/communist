package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.dto.array;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.FindRepository;
import com.ynu.demo.service.AdminFindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 22:32 2018/6/25
 */
@Service
@Slf4j
public class AdminFindServiceImpl implements AdminFindService {
    // 数据访问
    @Autowired
    private FindRepository findRepository;

    @Override
    public Page<PersonData> getList(Integer pageNum, Integer pageSize, String finding, String city, String sort, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;
        if(finding.equals("null")&&city.equals("null")){
            page = findRepository.findAll(pageable);
        }
        else if(finding.equals("null")&&!city.equals("null")){
            page = findRepository.findByCityLike("%"+city+"%",pageable);
        }else if(!finding.equals("null")&&city.equals("null")){
            page = findRepository.findByNameLike("%"+finding+"%",pageable);
        }else {
            page = findRepository.findByNameLikeAndCityLike("%"+finding+"%","%"+city+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.ERROR);
        }

        return page;
    }

    @Override
    public PersonData getById(Integer finding) {

        Optional result = findRepository.findById(finding);
        if(!result.isPresent()){
            throw new MyException(ResultEnum.ID_NOT_EXIST);
        }

        return (PersonData) result.get();
    }

    @Override
    public Page<PersonData> getListByName(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.findByName(finding,pageable);
        }else {
            page = findRepository.findByNameLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.NAME_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getGroupByCity(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.queryByCity(finding,pageable);
        }else {
            page = findRepository.queryByCityLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.CITY_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListBySex(Integer pageNum, Integer pageSize, String finding, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page = findRepository.findBySex(finding, pageable);

        if (!page.hasContent()){
            throw new MyException(ResultEnum.SEX_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByNationality(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.findByNationality(finding,pageable);
        }else {
            page = findRepository.findByNationalityLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.NATIONALITY_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByNativePlace(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.findByNativePlace(finding,pageable);
        }else {
            page = findRepository.findByNativePlaceLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.NATIVEPLACE_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByMarryStatus(Integer pageNum, Integer pageSize, String finding, String sort, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page = findRepository.findByMarryStatus(finding, pageable);

        if (!page.hasContent()){
            throw new MyException(ResultEnum.MARRYSTATUS_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByFamilyAddress(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.findByFamilyAddress(finding,pageable);
        }else {
            page = findRepository.findByFamilyAddressLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.FAMILYADDRESS_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByGraduation(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page = findRepository.findByGraduation(finding, pageable);

        if (!page.hasContent()){
            throw new MyException(ResultEnum.GRADUATION_NOT_EXIST);
        }

        return page;
    }

    @Override
    public Page<PersonData> getListByAcademicDegree(Integer pageNum, Integer pageSize, String finding, boolean isAccurate, String sort, String sortBy){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;

        if(isAccurate){
            page = findRepository.findByAcademicDegree(finding,pageable);
        }else {
            page = findRepository.findByAcademicDegreeLike("%"+finding+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.ACADEMICDEGREE_NOT_EXIST);
        }

        return page;
    }

    @Override
    public array[] findAllGroupByCity() {
        List<PersonData> list = findRepository.findAll();
        Map<String ,Integer> map = new HashMap<>();
        for (PersonData temp : list) {
            if(map.containsKey(temp.getCity())){
                map.put(temp.getCity(),map.get(temp.getCity())+1);
            }else {
                map.put(temp.getCity(),1);
            }
        }
        array[] arrays = new array[map.size()];
        int i = 0;
        for (String str : map.keySet()) {
            arrays[i] = new array(str,map.get(str));
            i++;
        }
        return arrays;
    }


}
