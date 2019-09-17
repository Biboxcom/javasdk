package com.github.bibixcom.enums;

//0钱包转币币; 1币币转钱包
public enum TransferSpotTypeEnum
{
    COIN(0), WALLET(1);
    int flag;

    TransferSpotTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
