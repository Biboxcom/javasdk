package com.github.bibixcom.enums;

/**
 * 合约类型
 * 1 开仓 2 平仓 3 爆仓 4 减仓
 */
public enum CTypeEnum
{
    OPEN(1), CLOSE(2), FORCE(3), SUB(4);
    int flag;

    CTypeEnum(int flag)
    {
        this.flag = flag;
    }

    public int getFlag()
    {
        return flag;
    }
}
