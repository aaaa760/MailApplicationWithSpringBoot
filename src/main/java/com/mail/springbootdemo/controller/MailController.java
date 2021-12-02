package com.mail.springbootdemo.controller;

import com.mail.springbootdemo.model.User;
import com.mail.springbootdemo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
public class MailController {

@Autowired
    private MailService Notification;
@Autowired
    private User user;


@RequestMapping("send-mail")
    public String send(){

    user.setFirstName("appala");
    user.setLastName("avinash");
    user.setEmailAddress("************@gmail.com");

    try{
        Notification.sendMail(user);
    }catch (MailException e){
        System.out.println(e);
    }
    return "you done it dude!";

}

    @RequestMapping("send-mail-attachment")
    public String sendAttachment() throws MessagingException {

        user.setFirstName("avinash");
        user.setLastName("appala");
        user.setEmailAddress("************@gmail.com");

        try{
            Notification.sendMailAttachment(user);
        }catch (MailException e){
            System.out.println(e);
        }
        return "you done it dude!";

    }
}
