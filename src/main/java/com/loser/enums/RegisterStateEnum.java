package com.loser.enums;

public enum RegisterStateEnum {
    EXISTS(0,"用户名已被注册"),
    ERROR(1,"注册信息错误"),
    SUCCESS(2,"注册成功");
//    UNDEFINED(3,"用户不存在");

    private int state;
    private String info;

    RegisterStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static RegisterStateEnum stateOf(int index)
    {
        for (RegisterStateEnum state : values())
        {
            if (state.getState() == index)
            {
                return state;
            }
        }
        return null;
    }

}
