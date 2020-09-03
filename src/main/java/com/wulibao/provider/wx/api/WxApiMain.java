package com.wulibao.provider.wx.api;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信API接口测试
 * 
 * @author WuliBao
 * @date 2020-07-20
 */
public class WxApiMain {
    /**
     * 违规文字检测地址
     */
    private static final String MSG_SEC_CHECK = "https://api.weixin.qq.com/wxa/msg_sec_check";
    
    /**
     * 违规图片检测地址
     */
    private static final String IMG_SEC_CHECK = "https://api.weixin.qq.com/wxa/img_sec_check";
    
    /**
     * token
     */
    private static final String ACCESS_TOKEN ="35_3XkmHw0zmZpjUbxRUlcgrKGoESczyH6bW-E3k4Y5cFRH-wW2jh63iZYqv35KM6pqww81ZhSaUhWtYyigN8nLtMCYnVLJHspUQgZ8HsRtDSYb6z9JmnrH80tz45hwYz44AlJUnrsGN2IL0idKLMUjAFAUVD";

    public static void main(String[] args)
        throws IOException {
        // 违规文字检测
        JSONObject msgOne = msgSecCheck(ACCESS_TOKEN, "习大大");
        System.out.println("违规文字检测");
        System.out.println(msgOne);
        // 合规文字检测
        JSONObject msgTwo = msgSecCheck(ACCESS_TOKEN, "雾里宝");
        System.out.println("合规文字检测");
        System.out.println(msgTwo);
        // File转MultipartFile
        File fileOne = new File("H:\\image\\黎明风景.jpg");
        // FileInputStream fileInputStream = new FileInputStream(file);
        // MultipartFile multipartFile =
        // new MockMultipartFile(file.getName(), file.getName(), "text/plain", fileInputStream);
        // // MultipartFile 转File
        // FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        // 合规图片检测
        JSONObject imgOne = imgSecCheck(ACCESS_TOKEN, fileOne);
        System.out.println("合规图片检测");
        System.out.println(imgOne);
        // 违规图片检测
        File fileTwo = new File("H:\\image\\违规图片.jpg");
        JSONObject imgTwo = imgSecCheck(ACCESS_TOKEN, fileTwo);
        System.out.println("违规图片检测");
        System.out.println(imgTwo);
    }
    
    /**
     * 文字检测
     * 
     * @param accessToken accessToken
     * @param content content
     * @return JSONObject
     */
    private static JSONObject msgSecCheck(String accessToken, String content) {
        RestTemplate restTemplate = new RestTemplate();
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        // 设置content-type
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        // 设置请求体
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        // 用HttpEntity封装整个请求报文
        HttpEntity<JSONObject> body = new HttpEntity<>(jsonObject, headers);
        return restTemplate.postForObject(MSG_SEC_CHECK + "?access_token=" + accessToken, body, JSONObject.class);
    }
    
    /**
     * 图片检测
     * 
     * @param accessToken accessToken
     * @param image image
     * @return JSONObject
     */
    private static JSONObject imgSecCheck(String accessToken, File image) {
        RestTemplate restTemplate = new RestTemplate();
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        // 设置content-type
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        // 设置请求体
        FileSystemResource fileSystemResource = new FileSystemResource(image);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("media", fileSystemResource);
        // 用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> body = new HttpEntity<>(form, headers);
        return restTemplate.postForObject(IMG_SEC_CHECK + "?access_token=" + accessToken, body, JSONObject.class);
    }
}
