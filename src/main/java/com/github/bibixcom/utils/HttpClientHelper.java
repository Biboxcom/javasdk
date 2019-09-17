package com.github.bibixcom.utils;

import com.alibaba.fastjson.JSON;
import com.github.bibixcom.common.UrlConstants;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class HttpClientHelper
{
    private static HttpClientHelper client;
    private OkHttpClient okHttpClient;

    public final MediaType mediaTypeJson = MediaType.get("application/json; charset=utf-8");

    public Map<String, Object> headers = new HashMap<>();
    public String baseHost = UrlConstants.DEFAULT_HOST;

    public static HttpClientHelper getOkHttpBuilder(OkHttpClient.Builder builder)
    {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (client == null) {
            client = new HttpClientHelper(builder);
        }
        lock.unlock();
        return client;
    }

    private Request.Builder buildRequest()
    {
        Request.Builder builder = new Request.Builder().url(baseHost);
        headers.entrySet().stream().forEach(entry -> builder.addHeader(entry.getKey(), entry.getKey()));
        return builder;
    }


    public void addHeader(String name, String value)
    {
        headers.put(name, value);
    }

    private HttpClientHelper(OkHttpClient.Builder builder)
    {
        okHttpClient = builder.build();
    }

    public String postBodyJson(String url, String data) throws IOException
    {
        System.out.println(String.format("method:%s request:%s params:%s", "POST JSON", url, data));
        RequestBody body = RequestBody.create(data, mediaTypeJson);
        Request request = buildRequest().url(url).post(body).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String ret = response.body().string();
            System.out.println(String.format("response:%s", ret));
            return ret;
        }
    }

    public String postForm(String url, Map<String, Object> params) throws IOException
    {
        System.out.println(String.format("method:%s request:%s params:%s", "POST", url, JSON.toJSONString(params)));
        FormBody.Builder builder = new FormBody.Builder();
        params.entrySet().stream().forEach(entry -> builder.add(entry.getKey(), entry.getValue().toString()));
        Request request = buildRequest().url(url).post(builder.build()).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String ret = response.body().string();
            System.out.println(String.format("response:%s", ret));
            return ret;
        }
    }

    public String get(String url, Map<String, Object> params) throws IOException
    {
        String urlGet = url.concat(paramsSplit(params));
        System.out.println(String.format("method:%s request:%s", "GET", urlGet));
        Request request = buildRequest().url(urlGet).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String ret = response.body().string();
            System.out.println(String.format("response:%s", ret));
            return ret;
        }
    }

    public static String paramsSplit(Map<String, Object> paramsMap)
    {
        List<String> params = paramsMap.entrySet().stream().map(entry -> entry.getKey().concat("=").concat(entry.getValue().toString())).collect(Collectors.toList());
        return params.stream().collect(Collectors.joining("&", "?", ""));
    }
}
