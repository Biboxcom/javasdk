package com.github.bibixcom.enums;

/**
 * -2：审核不通过；-1: 用户撤销；0:待审核; 1:审核通过（待发币）; 2: 发币中； 3：发币完成
 */
public enum WithdrawListFilterTypeEnum
{

    CHECK_FAIL(-2),

    USER_CANCEL(-1),

    WAIT_CHECK(0),

    CHECK_PASS(1),

    PROCESSING(2),

    FINISH(3);

    int flag;

    WithdrawListFilterTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
