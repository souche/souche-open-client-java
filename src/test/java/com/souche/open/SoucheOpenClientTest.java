package com.souche.open;

import com.alibaba.fastjson.JSON;
import com.souche.open.request.OapiUserInfoGetRequest;
import com.souche.open.response.OapiUserInfoGetResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoucheOpenClientTest {

    @Test
    void execute() {
        SoucheOpenClient client = new SoucheOpenClient(
                "your_host",
                "your_appKey",
                "your_appSecret"
        );

        OapiUserInfoGetRequest request = new OapiUserInfoGetRequest();

        request.setCode("temp_code");

        try {
            OapiUserInfoGetResponse resp = client.execute(request);
            System.out.println(resp.getBody());
        } catch (com.souche.open.ApiException e) {
            // nothing
        }
    }
}