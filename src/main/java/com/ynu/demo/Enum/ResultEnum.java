package com.ynu.demo.Enum;

import lombok.Getter;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:27 2018/6/29
 */
@Getter
public enum ResultEnum {
    REGISTER_FAILED(-1,"注册失败"),

    ERROR(0,"没有信息"),

    PARAM_ERROR(1, "参数不正确"),

    ID_NOT_EXIST(2,"ID不存在"),

    NAME_NOT_EXIST(3,"查找该姓名的党员不存在"),

    CITY_NOT_EXIST(4,"查找该所在城市的党员不存在"),

    SEX_NOT_EXIST(5,"查找该性别的党员不存在"),

    NATIONALITY_NOT_EXIST(6,"查找该民族的党员不存在"),

    NATION_NOT_EXIST(6,"查找该民族的党员不存在"),

    NATIVEPLACE_NOT_EXIST(7,"查找该籍贯的党员不存在"),

    MARRYSTATUS_NOT_EXIST(8,"查找该婚姻状况的党员不存在"),

    FAMILYADDRESS_NOT_EXIST(9,"查找该家庭住址不存在"),

    GRADUATION_NOT_EXIST(10,"查找该毕业院校系及专业的党员不存在"),

    ACADEMICDEGREE_NOT_EXIST(11,"查找该学历学位的党员不存在"),

    LOGIN_FAIL(50000,"登录失败"),

    NOT_LOGIN(50001,"用户未登录"),

    AUTHORITY_ERROR(50002,"用户没有权限"),

    AUTH_ERROR(50003,"权限验证失败"),

    DELETE_FAIL(60000,"删除失败"),

    ADMIN_ERROR(99998,"管理员不可删除"),

    ADMIN_NOT_UPDATE(99998,"管理员不可修改"),

    ADD_FAIL(70000,"添加失败"),

    UPDATE_FAIL(80000,"更新失败"),

    USER_NOT_EXIST(90000,"用户不存在"),

    ROLE_NOT_EXIST(99999,"角色不存在"),

    ID_NOT_CHANGE(60000,"ID不可更改"),

    JSON_ERROR(60001,"JSON创建失败"),

    IMAGE_ERROR(70000,"图片为空"),

    IMAGE_FORM_ERROR(70000,"图片格式错误"),

//    NO_AUTHORITY(3,"没有权限"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
