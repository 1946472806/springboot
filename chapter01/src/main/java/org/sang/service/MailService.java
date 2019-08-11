package org.sang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    //发送简单邮件
    public void sendSimpleMail(String from, String to, String cc, String subject, String content) {
        SimpleMailMessage simpMsg = new SimpleMailMessage();
        simpMsg.setFrom(from);
        simpMsg.setTo(to);
        simpMsg.setCc(cc);
        simpMsg.setSubject(subject);
        simpMsg.setText(content);
        javaMailSender.send(simpMsg);
    }

    //发送带附件的邮件
    public void sendAttachFileMail(String from, String to, String cc, String subject, String content, File file){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(file.getName(),file);
            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

    @Autowired
    TemplateEngine templateEngine;
    //使用Thymeleaf构建邮件模板
    public void sendHtmlMailThymeleaf(String from, String to, String cc, String subject,String username,String gender){
        Context ctx = new Context();
        ctx.setVariable("username",username);
        ctx.setVariable("gender",gender);
        String mails = templateEngine.process("mail.html",ctx);

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(mails,true);
            javaMailSender.send(message);
        }catch (MessagingException e){
            System.out.println("发送失败:"+e);
        }
    }
}
