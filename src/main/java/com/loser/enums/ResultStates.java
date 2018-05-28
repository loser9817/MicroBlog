package com.loser.enums;

/**
 * 统一返回格式
 * @param <T>为返回数据的类型
 */
public class ResultStates<T> {

    //状态码加信息
    private Result result;
    private int state;
    private String message;
    //数据
    private T data;

    //返回没有数据的构造方法（返回错误或者登陆注册等）

    public ResultStates(Result result) {
        this.result = result;
    }

    //返回有数据和状态码的构造方法

    public ResultStates(Result result, T data) {
        this.result = result;
        this.data = data;
    }

//    public Result getResult() {
//        return result;
//    }

    //获得Result的状态码
    public int getState() {
        return result.getState();
    }

    //获得Result的信息
    public String getMessage() {
        return result.getMessage();
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultStates{" +
                "result=" + result +
                ", data=" + data +
                '}';
    }
}
