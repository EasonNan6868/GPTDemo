package com.gptdemo.gptdemobackend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 对OpenAi接口的请求配置
 *
 * @author nan
 * 2023/3/23
 */

@Configuration
@ConfigurationProperties("chatgpt")
@ComponentScan
@Data
public class ChatGPTConfig {

    private String apiEndPoint="https://api.openai.com/v1/chat/completions";
    private String model;
    private String token;
    private String proxy_host;
    private String proxy_port;
    private String session_time;

}
