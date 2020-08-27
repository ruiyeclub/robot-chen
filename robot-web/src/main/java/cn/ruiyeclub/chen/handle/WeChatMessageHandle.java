package cn.ruiyeclub.chen.handle;

import cn.ruiyeclub.chen.domain.WeChatMessage;

/**
 * 处理微信消息接口类
 */
public interface WeChatMessageHandle {

    String processMessage(WeChatMessage weChatMessage);
}
