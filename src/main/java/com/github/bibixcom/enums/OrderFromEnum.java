package com.github.bibixcom.enums;

/**
 * WEB: 1, //网页
 * ANDROID: 2, //安卓
 * IOS: 3, //ios
 * PC: 4, //PC客户端
 * SYSTEM: 5, //系统
 * APIKEY: 6, //apikey
 */
public enum OrderFromEnum
{
    WEB(1), ANDROID(2), IOS(3), PC(4), SYSTEM(5), API_KEY(6);
    int flag;

    OrderFromEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
