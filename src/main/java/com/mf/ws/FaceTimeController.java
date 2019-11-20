package com.mf.ws;

import com.alibaba.fastjson.JSON;
import com.mf.bo.MessageBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class FaceTimeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendOffer")
    public void handleSendOffer(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/" + messageBO.getReceiver(), messageBO);
    }
}
