package cn.ruiyeclub.chen.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应消息基类（公众帐号 -> 普通用户）
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseMessage {

    /**
     * 接收方帐号（收到的OpenID）
     **/
    @XStreamAlias("ToUserName")
    private String toUserName;

    /**
     * 开发者微信号
     **/
    @XStreamAlias("FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间
     **/
    @XStreamAlias("CreateTime")
    private Long createTime;

    /**
     * 消息类型
     **/
    @XStreamAlias("MsgType")
    private String msgType;

}
