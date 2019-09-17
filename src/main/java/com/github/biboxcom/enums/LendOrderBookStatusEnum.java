package com.github.bibixcom.enums;

/**
 * 0未成交, 1部分成交, 2已完成
 */
public enum LendOrderBookStatusEnum
{
    WAIT_DEAL(0), DEAL_PART(1), DEAL_ALL(2);
    int flag;

    LendOrderBookStatusEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
