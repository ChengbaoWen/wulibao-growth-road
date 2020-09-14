package com.wulibao.provider.wx.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信分享二维码接口
 * 
 * @author WuliBao
 * @date 2020-09-10
 */
public class QrCodeMain {
    /**
     * 小程序码接口地址
     */
    private static final String CREATE_WXAQR_CODE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode";
    
    /**
     * token
     */
    private static final String ACCESS_TOKEN =
        "35_3XkmHw0zmZpjUbxRUlcgrKGoESczyH6bW-E3k4Y5cFRH-wW2jh63iZYqv35KM6pqww81ZhSaUhWtYyigN8nLtMCYnVLJHspUQgZ8HsRtDSYb6z9JmnrH80tz45hwYz44AlJUnrsGN2IL0idKLMUjAFAUVD";
    
    public static void main(String[] args) {
        JSONObject wxaqrCode = createWxaqrCode(ACCESS_TOKEN, "index/demo", 430);
        System.out.println(wxaqrCode);
    }
    
    /**
     * 文字检测
     *
     * @param accessToken accessToken
     * @param path path
     * @param width width
     * @return JSONObject
     */
    private static JSONObject createWxaqrCode(String accessToken, String path, Integer width) {
        RestTemplate restTemplate = new RestTemplate();
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        // 设置content-type
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        // 设置请求体
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path", path);
        jsonObject.put("width", width);
        // 用HttpEntity封装整个请求报文
        HttpEntity<JSONObject> body = new HttpEntity<>(jsonObject, headers);
        return restTemplate.postForObject(CREATE_WXAQR_CODE + "?access_token=" + accessToken, body, JSONObject.class);
    }
}
