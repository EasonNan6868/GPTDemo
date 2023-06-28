package com.gptdemo.gptdemobackend.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gptdemo.gptdemobackend.config.ChatGPTConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求OpenAI的逻辑
 *
 * @author nan
 * 2023/3/23
 */

@Service
public class OpenAI {

    @Autowired
    ChatGPTConfig chatGPTConfig;

    public String getChatResult(String message){
        Map<String,Object> requestMap=new HashMap<>();
        requestMap.put("model",chatGPTConfig.getModel());
        List<Map<String,String>> requestList= new ArrayList<>();
        Map<String,String> messageMap=new HashMap<>();
        messageMap.put("role","user");
        messageMap.put("content",message);
        requestList.add(messageMap);
        requestMap.put("messages",requestList);
        String requestContent= JSONUtil.toJsonStr(requestMap);
        String body= HttpRequest.post(chatGPTConfig.getApiEndPoint())
                .header("Authorization","Bearer "+chatGPTConfig.getToken())
                .header("Content-Type","application/json")
                .body(requestContent)
                .execute()
                .body();
        JSONObject resultObject = JSONUtil.parseObj(body);
        JSONArray choicesArray = resultObject.getJSONArray("choices");
        JSONObject result = choicesArray.get(0, JSONObject.class, true);
        JSONObject messageResult = result.getJSONObject("message");
        return messageResult.getStr("content");

    }

}
