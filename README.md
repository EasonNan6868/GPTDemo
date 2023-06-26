# GPTDemo
基于Vue+springBoot的前后端分离项目，实现了对OpenAI的ChatGPT模型的基本调用。
- - -
## 配置
### 前端
- 如果后端的端口被占用需要更改，那么同时也需要去更改前端的跨域配置，在前端的根目录vue.config.js文件中更改proxy中target的参数值为后端的地址。
![](/static/p4.png)
### 后端
- 项目的API-SecretKey为空，使用前需要到后端src/resources/application.yml配置文件中配置token参数为你自己的OpenAI密钥。
![](/static/p3.png)
- 如需更改请求模型或其他请求配置可以去config包下的ChatGPTConfig.java文件中自定义参数，后续通过配置文件配置参数，将配置完的参数替换掉Http请求中的参数即可。
## 运行
### 前端
- 项目中并没有包含运行所需要的库即node_modules目录，需要自己运行安装库文件，定位到前端目录下执行`npm install`即可。
- 运行执行`npm run serve`
### 后端
- 后端为SpringBoot项目，打包成jar包或直接运行即可，注意如果端口冲突需要去配置文件中更改端口号。
## 示例
### 前端
![](/static/p1.png)
### 后端
![](/static/p2.png)
## 注意事项
- token项为必填项，需要填写你当前未过期的OpenAI API密匙，不填会导致报错401未授权。
- 如果请求模型需要更改，那么请求对应的URL也需要更改，具体地址请阅读OpenAI官方文档。
- 使用时需要注意文本的内容和长度，项目中并未加以限制，但过长或非法的内容会影响接口的响应速度跟加剧代币的消耗。
- 使用时需要保证网络可用以及网络连接的稳定性跟速度。