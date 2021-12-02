package com.mail.springbootdemo.service;


import com.mail.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;


@Service
public class MailService {
    final private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public  void sendMail(User user) throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmailAddress());
        message.setSubject("Testing my mail");
        message.setText("hello this is avinash created a mail api in springboot and testing it");
        javaMailSender.send(message);
    }

    public void sendMailAttachment(User user) throws MailException , MessagingException{
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper help = new MimeMessageHelper(mail,true);
        help.setTo(user.getEmailAddress());
        help.setSubject("Testing my mailApi with a attachment");
        help.setText("Please find the attachment below");

        ClassPathResource r = new ClassPathResource("testing.pdf");
        help.addAttachment(Objects.requireNonNull(r.getFilename()),r);
        javaMailSender.send(mail);
    }
}
