package com.github.bibixcom.enums;

public enum COrderSideEnum
{

    //开多
    UP(1),

    //开空
    DOWN(2);

    int flag;

    COrderSideEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
