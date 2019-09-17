package com.github.bibixcom.enums;

/**
 * 0待收款, 1部分收款, 2已全部收款
 */
public enum LendOrderStatusEnum
{
    WAIT_GET(0), DEAL_PART_GET(1), DEAL_ALL_GET(2);
    int flag;

    LendOrderStatusEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
