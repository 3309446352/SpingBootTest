package com.example.demo.User.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * (User)表配置类
 * @since 2024-03-04 23:16:00
 */
@Component
@Setter
@Getter
public class ResultInfo<T> {
    final static Integer SUCCESS = 200;
    final static Integer ERROR = 400;
    final static Integer NOT_FOUND = 404;
    final static Integer SERVER_ERROR = 500;

    private Integer code;
    private String message;
    private T data;

    public void Success(T data){
        this.code = SUCCESS;
        this.message = "success";
        this.data = data;
    }
    public void error(Integer code, String message){
        this.code = code == null ? ERROR : code;
        this.message = message;
    }
    public void notFound(){
        this.code = NOT_FOUND;
        this.message = "not found";
        this.data = null;

    }
    public void serverError(){
        this.code = SERVER_ERROR;
        this.message = "server error服务器错误请稍后重试";
        this.data = null;
    }

    public String Fail(String s) {
        return "用户不存在" ;
    }
    public String setResultInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        return "code:"+code+"message:"+message;
    }
}
