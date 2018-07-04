package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.PersonData;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.UserRepository;
import com.ynu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 0:11 2018/7/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<PersonData> getList(Integer pageNum, Integer pageSize, String finding, String city, String sort, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.valueOf(sort), sortBy);
        Page<PersonData> page;
        if(finding.equals("null")&&city.equals("null")){
            page = userRepository.findAll(pageable);
        }
        else if(finding.equals("null")&&!city.equals("null")){
            page = userRepository.findByCityLike("%"+city+"%",pageable);
        }else if(!finding.equals("null")&&city.equals("null")){
            page = userRepository.findByNameLike("%"+finding+"%",pageable);
        }else {
            page = userRepository.findByNameLikeAndCityLike("%"+finding+"%","%"+city+"%",pageable);
        }

        if (!page.hasContent()){
            throw new MyException(ResultEnum.ERROR);
        }

        return page;
    }

    @Override
    public UserRolePermissions save(UserRolePermissions userRolePermissions) {
        return userRepository.save(userRolePermissions);
    }
}
