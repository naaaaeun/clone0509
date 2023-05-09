package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.MsgAdm;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class ScheduleController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    CartService service;


    @Scheduled(cron = "*/15 * * * * *")
    public void cronJobDailyUpdate() {

        Random r =new Random();
        int content1 = r.nextInt(100)+1;
        int content2 = r.nextInt(1000)+1;
        int content3 = r.nextInt(500)+1;
        int content4 = r.nextInt(10)+1;

        MsgAdm msg=new MsgAdm();
        msg.setContent1(content1);
        msg.setContent2(content2);
        msg.setContent3(content3);
        msg.setContent4(content4);
        messagingTemplate.convertAndSend("/sendadm", msg);
    }

    @Scheduled(cron = "*/18 * * * * *")
    public void cronJobWeeklyUpdate() throws Exception {
        List<Cart> list= service.get();
        int num=0;
        for(Cart cart:list){
            num+=cart.getItem_price()*cart.getCnt();
        }
        log.info(""+num);
    }


}