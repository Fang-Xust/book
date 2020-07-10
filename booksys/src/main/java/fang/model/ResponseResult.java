package fang.model;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 20-50-23
 **/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http请求返回响应的统一格式
 * 具体需要的字段，是前端后端约定好的
 */
@Getter
@Setter
@ToString
public class ResponseResult {

    private boolean success;//前端响应状态码为200，但是success可以为false
    private String code;//自定义的消息编码
    private String message;//自定义的消息内容
    private Integer total;//分页需要的字段：查询总的行数
    private Object data;//业务数据
    private String stackTrace;//出现异常时的堆栈信息
}
