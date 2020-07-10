package com.beidou.tree.util;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/10 0010 11:40
 */
import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable{

    private String res = "-1";
    private String error = "系统异常";
    private Object data;
    private boolean success = false;

    public Result() {

    }
    public Result success(Object data) {
        this.setRes("0");
        this.setError("请求成功");
        this.setData(data);
        this.success = true;
        return this;
    }
    public Result error(String error) {
        this.error = error;
        return this;
    }
    public Result(String res,String error) {
        this.res = res;
        this.error = error;
        this.success = "0".equals(res);
    }
    public boolean isSuccess() {
        return success;
    }
    public String getRes() {
        return res;
    }
    public void setRes(String res) {
        this.res = res;
        this.success = "0".equals(res);
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}