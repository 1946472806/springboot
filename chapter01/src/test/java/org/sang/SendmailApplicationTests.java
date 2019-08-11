package org.sang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendmailApplicationTests {
    @Autowired
    MailService mailService;
    //发送简单邮件
    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1946472806@qq.com",
                "1946472806@qq.com",
                "1946472806@qq.com",
                "测试邮件主题",
                "测试邮件内容");
    }

    //发送带附件的邮件
    @Test
    public void sendAttachFileMail(){
        mailService.sendAttachFileMail(
                "1946472806@qq.com",
                "1946472806@qq.com",
                "1946472806@qq.com",
                "测试邮件主题带附件",
                "测试邮件内容带附件",
                new File("D:\\注册码.txt"));
    }

    //使用Thymeleaf构建邮件模板
    @Test
    public void sendHtmlMailThymeleafs(){
        mailService.sendHtmlMailThymeleaf(
                "1946472806@qq.com",
                "1946472806@qq.com",
                "1946472806@qq.com",
                "测试邮件主题模板格式",
                "sang",
                "女"
        );
    }
}
