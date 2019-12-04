package com.mf.ws;

import com.mf.bo.MessageBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class ClassPowerPointController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/back")
    public void handleBackPPT(MessageBO messageBO) {
        String desc = "/topic/ppt/back/" + messageBO.getReceiver();
        messagingTemplate.convertAndSend(desc, messageBO);
    }

    @MessageMapping("/next")
    public void handleNextPPT(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/ppt/next/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendPaletteOffer")
    public void handleSendPaletteOffer(MessageBO messageBO) {
        String desc = "/topic/sendPaletteOffer/" + messageBO.getReceiver();
        messagingTemplate.convertAndSend(desc, messageBO);
    }

    @MessageMapping("/sendPaletteAnswer")
    public void handleSendPaletteAnswer(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendPaletteAnswer/" + messageBO.getReceiver(), messageBO);
    }

    @MessageMapping("/sendPaletteICE")
    public void handleSendPaletteICE(MessageBO messageBO) {
        messagingTemplate.convertAndSend("/topic/sendPaletteICE/" + messageBO.getReceiver(), messageBO);
    }
}
