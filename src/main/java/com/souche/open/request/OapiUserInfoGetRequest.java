package com.souche.open.request;

import com.souche.open.response.OapiUserInfoGetResponse;

import java.util.HashMap;

public class OapiUserInfoGetRequest extends BaseRequest<OapiUserInfoGetResponse> {
    /**
     * 通过 Oauth2 获取的 Code
     */
    private String code;
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getApiMethodName() {
        return "/oauth2/userInfo";
    }

    @Override
    public HashMap<String, String> getTextParams() {
        HashMap<String, String> textParamsMap = new HashMap<>();
        textParamsMap.put("code",  this.code);
        return textParamsMap;
    }

    @Override
    public Class<OapiUserInfoGetResponse> getResponseClass() {
        return OapiUserInfoGetResponse.class;
    }
}