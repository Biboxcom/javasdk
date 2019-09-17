package com.github.bibixcom.vo;

import com.github.bibixcom.enums.LendOrderBookStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LendOrderBookGetParams
{
    //交易币种
    private String coinSymbol;
    //订单状态
    private List<LendOrderBookStatusEnum> status = new ArrayList<>();
    //第几页
    private Integer page;
    //每页数量
    private Integer size;

    public String getCoinSymbol()
    {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol)
    {
        this.coinSymbol = coinSymbol;
    }

    public List<LendOrderBookStatusEnum> getStatus()
    {
        return status;
    }

    public boolean addStatus(LendOrderBookStatusEnum s)
    {
        return status.add(s);
    }

    public List<Integer> flags()
    {
        return status.stream().map(LendOrderBookStatusEnum::getFlag).collect(Collectors.toList());
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
