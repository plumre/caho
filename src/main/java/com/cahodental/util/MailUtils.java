package com.cahodental.util;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:56
 */
public class MailUtils {

    public static void sendMail(String to, String code) throws MessagingException {
        // 创建连接
        Properties props = new Properties();
        props.setProperty("host", "localhost");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("service@cahodental.com", "service");
            }
        });

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("service@cahodental.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject("Activation request from CAHO");
        msg.setContent("<h1>请点击以下链接激活账户:</h1><h3><a href='http://localhost:8080/caho/ActiveServlet?code="+code+"'>http://localhost:8080/caho/ActiveServlet?code='+code+'</a></h3>", "text/html;charset=utf-8");
        // 发送激活邮件
        Transport.send(msg);


    }

}