package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.UserRolePermissionsRepository;
import com.ynu.demo.service.UserRolePermissionsService;
import com.ynu.demo.utils.KeyUtil;
import com.ynu.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:36 2018/7/3
 */
@Service
public class UserRolePermissionsServiceImpl implements UserRolePermissionsService {

    @Autowired
    private UserRolePermissionsRepository userRolePermissionsRepository;


    @Override
    public Page<UserRolePermissions> getList(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserRolePermissions> page = userRolePermissionsRepository.findAll(pageable);
        for (int i = 0; i < page.getTotalElements(); i++) {
            page.getContent().get(i).setPassword("");
        }
        return page;
    }

    @Override
    public void updateUser(UserRolePermissions userRolePermissions) {
        UserRolePermissions temp = userRolePermissionsRepository.findById(userRolePermissions.getId()).get();
        if(temp.getRole().equals("admin")){
            throw new MyException(ResultEnum.ADMIN_NOT_UPDATE);
        }
        if(userRolePermissions.getUsername()!=null){
            temp.setUsername(userRolePermissions.getUsername());
        }
        if(userRolePermissions.getPassword()!=null){
            String password = userRolePermissions.getPassword();
            temp.setPassword(MD5Util.MD5(password,userRolePermissions.getId()));
        }
        if (userRolePermissions.getRole()!=null){
            temp.setRole(userRolePermissions.getRole());
        }
        userRolePermissionsRepository.save(temp);
    }

    @Override
    public void addUser(UserRolePermissions userRolePermissions) {
        userRolePermissions.setId(KeyUtil.getUniqueKey());
        userRolePermissions.setPassword(MD5Util.MD5(userRolePermissions.getPassword(),userRolePermissions.getId()));
        userRolePermissionsRepository.save(userRolePermissions);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRolePermissionsRepository.findById(id).isPresent()){
            throw new MyException(ResultEnum.ID_NOT_EXIST);
        }
        if(userRolePermissionsRepository.findById(id).get().getRole().equals("admin")){
            throw new MyException(ResultEnum.ADMIN_ERROR);
        }
        userRolePermissionsRepository.deleteById(id);
    }

    @Override
    public Page<UserRolePermissions> findAllByRole(Integer pageNum, Integer pageSize, String title,String finding) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserRolePermissions> page;
        if(title==null){
            page = userRolePermissionsRepository.findAll(pageable);
        }else{
            page = userRolePermissionsRepository.findAllByUsernameLikeAndRoleIs("%"+title+"%",finding,pageable);
        }
        for (int i = 0; i < page.getTotalElements(); i++) {
            page.getContent().get(i).setPassword("");
        }
        return page;
    }


}
