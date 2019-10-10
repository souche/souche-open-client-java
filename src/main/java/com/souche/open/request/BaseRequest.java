package com.souche.open.request;
import com.souche.open.response.BaseResponse;

import java.util.HashMap;

public abstract class BaseRequest<T extends BaseResponse> {
    public static enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    };

    protected HttpMethod httpMethod = HttpMethod.GET;
    protected String appKey = "";
    protected long timestamp = -1;

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    public String getAppKey() {
        return appKey;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public abstract HashMap<String, String> getTextParams();

    public abstract Class<T> getResponseClass();
}
