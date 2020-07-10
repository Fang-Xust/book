package fang.exception;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 20-10-01
 **/

public class BusinessException extends BaseException {
    public BusinessException(String code, String message){
        super("BUS"+ code, "业务错误" + message);
    }

    public BusinessException(String code, String message, Throwable cause){
        super("BUS"+ code, "业务错误" + message, cause);
    }
}
