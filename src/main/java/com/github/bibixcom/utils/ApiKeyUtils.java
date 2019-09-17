package com.github.bibixcom.utils;

import com.alibaba.fastjson.JSON;
import com.github.bibixcom.exceptions.ApiKeyException;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiKeyUtils
{
    public static String createParams(String cmd, Map<String, Object> params)
    {
        List<Map<String, Serializable>> data = new ArrayList<>();
        Map<String, Serializable> cmdMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>(params);
        cmdMap.put("cmd", cmd);
        cmdMap.put("body", bodyMap);
        data.add(cmdMap);
        return JSON.toJSONString(data);
    }

    /**
     * data sign
     *
     * @param secret
     * @param data
     * @return
     */
    public static String sign(String secret, String data)
    {
        if (StringUtils.isEmpty(secret)) {
            throw new ApiKeyException("API secret is require");
        }
        return HmacUtils.hmacMd5Hex(secret, data);
    }
}
