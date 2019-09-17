package com.github.bibixcom.vo;

import com.github.bibixcom.enums.LendOrderStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LendOrderGetParams
{
    //交易币种id
    private Long coinId;
    //订单状态
    private List<LendOrderStatusEnum> status = new ArrayList<>();
    private Integer page;
    private Integer size;

    public Long getCoinId()
    {
        return coinId;
    }

    public void setCoinId(Long coinId)
    {
        this.coinId = coinId;
    }

    public List<Integer> flags()
    {
        return status.stream().map(LendOrderStatusEnum::getFlag).collect(Collectors.toList());
    }

    public boolean addStatus(LendOrderStatusEnum s)
    {
        return status.add(s);
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }
}
