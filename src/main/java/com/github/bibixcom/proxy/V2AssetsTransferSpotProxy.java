package com.github.bibixcom.proxy;

import com.alibaba.fastjson.JSON;
import com.github.bibixcom.BiBoxHttpClientConfig;
import com.github.bibixcom.common.UrlConstants;
import com.github.bibixcom.enums.TransferSpotTypeEnum;
import com.github.bibixcom.utils.ApiKeyUtils;
import com.github.bibixcom.utils.HttpClientHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class V2AssetsTransferSpotProxy extends BaseProxy
{

    public V2AssetsTransferSpotProxy(BiBoxHttpClientConfig config, HttpClientHelper helper)
    {
        super.config = config;
        super.helper = helper;
    }

    @Override
    public String getUrl()
    {
        return config.getHost().concat(UrlConstants.V2_ASSETS_TRANSFER_SPOT);
    }

    public String transferSpot(String symbol, String amount, TransferSpotTypeEnum type) throws IOException
    {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        params.put("amount", amount);
        params.put("type", type.getFlag());
        String jsonParams = JSON.toJSONString(params);
        //        return helper.postForm(getUrl(), params);
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("body", jsonParams);
        postBody.put("apikey", config.getApiKey());
        postBody.put("sign", ApiKeyUtils.sign(config.getSecret(), jsonParams));
        return helper.postBodyJson(getUrl(), JSON.toJSONString(postBody));
    }
}
