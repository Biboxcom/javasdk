package com.github.bibixcom.enums;

/**
 * 0未成交, 1借款成功, 2部分还款, 3-6已完成
 */
public enum BorrowOrderStatusEnum
{
    WAIT_DEAL(0),

    BORROW_SUCCESS(1),

    REFOUND_PART(2),

    REFOUND_SUC_3(3),

    REFOUND_SUC_4(4),

    REFOUND_SUC_5(5),

    REFOUND_SUC_6(6);

    int flag;

    BorrowOrderStatusEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
