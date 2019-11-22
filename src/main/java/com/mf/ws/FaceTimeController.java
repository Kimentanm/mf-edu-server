package com.mf.ws;

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
        String desc = "/topic/sendOffer/" + messageBO.getReceiver();
        messagingTemplate.convertAndSend(desc, messageBO);
    }

    @MessageMapping("/sendAnswer")
    public void handleSendAnswer(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendAnswer/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendICE")
    public void handleSendICE(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendICE/" + messageBO.getReceiver(), messageBO);
    }
}
