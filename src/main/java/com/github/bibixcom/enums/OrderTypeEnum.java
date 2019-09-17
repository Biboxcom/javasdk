package com.github.bibixcom.enums;

public enum OrderTypeEnum
{
    //市价单
    MARKET(1),

    //限价单
    LIMIT(2);

    int flag;

    OrderTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
