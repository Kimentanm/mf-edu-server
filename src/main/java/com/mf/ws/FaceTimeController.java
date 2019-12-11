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

    @MessageMapping("/sendStartRequest")
    public void handleSendStartRequest(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendStartRequest/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendStartResponse")
    public void handleSendStartResponse(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendStartResponse/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendCloseRequest")
    public void handleSendCloseRequest(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendCloseRequest/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendStudentBlur")
    public void handleSendStudentBlur(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendStudentBlur/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendStudentFocus")
    public void handleSendStudentFocus(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendStudentFocus/" + messageBO.getReceiver(), messageBO);
    }
}
