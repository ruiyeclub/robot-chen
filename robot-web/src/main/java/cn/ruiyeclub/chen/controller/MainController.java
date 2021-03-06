package cn.ruiyeclub.chen.controller;

import cn.ruiyeclub.chen.service.WeChatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/weChat")
@Slf4j
public class MainController {

    @Resource
    private WeChatService weChatService;

    /**
     * 接收来至微信服务器的消息
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param request
     * @param response
     * @return true or false
     */
    @GetMapping("receiveMessage")
    public String receiveMessage(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request, HttpServletResponse response) {
        String result;
        if (HttpMethod.GET.name().equals(request.getMethod())) {
            // 验证签名是否有效
            if (weChatService.checkSignature(signature, timestamp, nonce)) {
                result = echostr;
            } else {
                result = "你是谁？你想干嘛？";
            }
        } else {
            try {
                result = weChatService.processReceived(request.getInputStream());
            } catch (Exception e) {
                log.error("获取来自微信的消息异常", e);
                result = StringUtils.EMPTY;
            }
        }
        return result;
    }

}
