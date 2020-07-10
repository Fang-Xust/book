package fang.exception;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 20-10-01
 **/
//客户端异常
public class ClientException extends BaseException {
    public ClientException(String code, String message){
        super("CLT"+ code, "客户端错误" + message);
    }

    public ClientException(String code, String message, Throwable cause){
        super("CLT"+ code, "客户端错误" + message, cause);
    }
}
