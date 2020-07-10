package fang.exception;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 20-10-01
 **/

public class SystemException extends BaseException {
    public SystemException(String code, String message){
        super("SYS"+ code, "系统异常" + message);
    }

    public SystemException(String code, String message, Throwable cause){
        super("SYS"+ code, "系统错误" + message, cause);
    }
}
