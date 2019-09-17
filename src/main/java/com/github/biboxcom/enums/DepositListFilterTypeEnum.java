package com.github.bibixcom.enums;

/**
 * 0-全部，1-充值进行中，2-充值到账，3-充值失败
 */
public enum DepositListFilterTypeEnum
{

    PROCESSING(1),

    FINISH(2),

    FAIL(3),

    ALL(0);

    int flag;

    DepositListFilterTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
