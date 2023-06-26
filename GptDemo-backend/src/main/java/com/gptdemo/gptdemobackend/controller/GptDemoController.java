package com.gptdemo.gptdemobackend.controller;

import com.gptdemo.gptdemobackend.model.DemoRequest;
import com.gptdemo.gptdemobackend.service.OpenAI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对接前端的请求接口
 *
 * @author nan
 * 2023/3/23
 */

@RestController()
@RequestMapping("/gpt")
public class GptDemoController {

    @Autowired
    OpenAI openAI;

    @PostMapping("/invoke")
    public String invokeGpt(@RequestBody DemoRequest demoRequest){
        System.out.println(demoRequest);
        String result = openAI.getChatResult(demoRequest.getMessage());
        System.out.println(result);
        return result;

    }

}
