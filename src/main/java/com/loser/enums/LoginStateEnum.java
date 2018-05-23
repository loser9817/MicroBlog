package com.loser.enums;

public enum LoginStateEnum {
    USER_UNDEFINED(0,"用户未注册"),
    PASSWORD_ERROR(1,"密码错误"),
    LOGIN_SUCCESS(2,"登录成功");

    private int state;
    private String info;

    LoginStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static LoginStateEnum stateOf(int index)
    {
        for (LoginStateEnum state : values())
        {
            if (state.getState() == index)
            {
                return state;
            }
        }
        return null;
    }

}
