package com.souche.open;

import com.alibaba.fastjson.JSON;
import com.souche.open.request.BaseRequest;
import com.souche.open.response.BaseResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 大搜车开放平台客户端
 * @author plusman 2019-09-10 14:33:39
 */
public class SoucheOpenClient {
    private String serverUrl;
    private String appKey = "";
    private String appSecret = "";
    private final OkHttpClient client = new OkHttpClient();

    public SoucheOpenClient (
            String serverUrl,
            String appKey,
            String appSecret
    ) {
        this.serverUrl = serverUrl;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public SoucheOpenClient (
            String serverUrl
    ) {
        this.serverUrl = serverUrl;
    }

    /**
     * 执行隐私 API 请求
     * @param request 具体的 API 请求类
     * @return T 具体的 API 响应类
     * @throws ApiException if HttpRequest Fail
     */
    public <T extends BaseResponse> T execute(BaseRequest<T> request) throws ApiException {
        // 获取当前时间
        long start = System.currentTimeMillis();

        // 对参数进行排序
        TreeMap<String, String> sortQs = new TreeMap<>(Comparator.naturalOrder());
        sortQs.putAll(request.getTextParams());
        sortQs.put("timestamp", start + "");

        if(!this.appKey.isEmpty()) {
            sortQs.put("appKey", this.appKey);
        }

        // 如果秘钥不为空，则进行参数加密，添加 signature 参数
        if(!this.appSecret.isEmpty()) {
            String sortStr = generateQuery(sortQs);
            String base64SortQs = Base64.getEncoder().encodeToString(sortStr.getBytes());
            String sha1Signature = sign(this.appSecret + ":" + base64SortQs);
            sortQs.put("signature", sha1Signature);
        }

        // 发起网络请求
        Request okRequest = new Request.Builder()
                .url(this.serverUrl + "/oauth2/userInfo?" + generateQuery(sortQs))
                .build();

        try (
                Response response = client.newCall(okRequest).execute()
        ) {
            String body = response.body().string();
            T result = JSON.parseObject(body, request.getResponseClass());

            // 将原始 body 注入
            result.setBody(body);

            return result;
        } catch (IOException e) {
            ApiException apiE = new ApiException();
            apiE.initCause(e);
            throw apiE;
        }
    }

    private static String generateQuery(AbstractMap<String, String> hashMap) {
        StringBuilder query = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : hashMap.entrySet()) {
            if(!first) {
                query.append("&");
            }
            query.append(
                    urlEncode(entry.getKey()) + "=" +
                            urlEncode(entry.getValue())
            );

            first = false;
        }

        return query.toString();
    }

    /**
     * URL 编码
     * @param value
     * @return
     */
    private static String urlEncode(String value) {
        if( value == null) {
            return "";
        }

        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
            return "";
        }
    }

    /**
     * 签名
     * @param value
     * @return
     */
    private static String sign(String value) {
        if( value == null ) {
            return  "";
        }

        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = sha1.digest(value.getBytes());

            String result = "";
            for (int i=0; i < messageDigest.length; i++) {
                result += Integer.toString( ( messageDigest[i] & 0xff ) + 0x100, 16).substring(1);
            }
            return result;

        } catch(NoSuchAlgorithmException e) {
            System.err.println(e);
        }

        return "";
    }
}