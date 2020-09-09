package com.aaa.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author WH
 * @date 2020/9/2 10:12
 */
public class EmailHelper {
    private static final String sendFrom = "whwh173@163.com";
    private static final String username = "whwh173@163.com";
    private static final String password = "whwh123123";
    private static final String host = "smtp.163.com";//邮件服务器主机host,目前只支持SMTP协议(163或qq)  网易默认是：smtp.163.com
    private static final String smtp = "smtp";//邮件 SMTP协议
    private static final String authorization_code = "KIJURNPNMAUSAMMX";//授权码KIJURNPNMAUSAMMX  NBUSMMRWUMAULVVX

    public static void sendEmail(String someone, String verification_code){
        Properties props = new Properties();
        props.setProperty("mail.host", host);//设置 邮件服务器
        props.setProperty("mail.transport.protocol", smtp); // 邮件发送协议
        props.setProperty("mail.smtp.auth", "true");// 需要验证用户名密码
        Session session = Session.getInstance(props,new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication(username, authorization_code);
            }
        });
        session.setDebug(true); //可以通过session开启Dubug模式，查看所有的过程

        try {
            Transport tp = session.getTransport();
            //3.连接服务器,需要抛出异常；
            tp.connect(host,sendFrom,authorization_code);
            MimeMessage mimeMessage = imageMail(session,someone,verification_code);
            mimeMessage.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(username));
            tp.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MimeMessage imageMail(Session session,String someone,String verification_code) throws MessagingException {
        //消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);
        //邮件发送人
        mimeMessage.setFrom(new InternetAddress(sendFrom));
        //邮件接收人，可以同时发送给很多人，我们这里只发给自己；
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(someone));
        mimeMessage.setSubject(verification_code); //邮件主题标题
        //编写邮件内容1.图片2.附件3.文本
        //文本
        MimeBodyPart body1 = new MimeBodyPart();
        body1.setContent("欢迎使用大问好，验证码："+verification_code,"text/html;charset=utf-8");
        /*
        //图片
        MimeBodyPart body2 = new MimeBodyPart();
        body2.setDataHandler(new DataHandler(new FileDataSource("src/resources/yhbxb.png")));
        body2.setContentID("yhbxb.png"); //图片设置ID
        //附件
        MimeBodyPart body3 = new MimeBodyPart();
        body3.setDataHandler(new DataHandler(new FileDataSource("src/resources/log4j.properties")));
        body3.setFileName("log4j.properties"); //附件设置名字
        //文件
        MimeBodyPart body4 = new MimeBodyPart();
        body4.setDataHandler(new DataHandler(new FileDataSource("src/resources/1.txt")));
        body4.setFileName(""); //附件设置名字
        */
        //拼装邮件正文内容
        MimeMultipart multipart1 = new MimeMultipart();
        multipart1.addBodyPart(body1);
        //multipart1.addBodyPart(body2);
        //multipart1.setSubType("related"); //1.文本和图片内嵌成功！
        //new MimeBodyPart().setContent(multipart1); //将拼装好的正文内容设置为主体
        MimeBodyPart contentText =  new MimeBodyPart();
        contentText.setContent(multipart1);
        /*
        //拼接附件
        MimeMultipart allFile =new MimeMultipart();
        allFile.addBodyPart(body3); //附件
        allFile.addBodyPart(body4); //附件
        allFile.addBodyPart(contentText);//正文
        allFile.setSubType("mixed"); //正文和附件都存在邮件中，所有类型设置为mixed；
        //放到Message消息中
        mimeMessage.setContent(allFile);
        */
        MimeMultipart allFile =new MimeMultipart();
        allFile.addBodyPart(contentText);//正文
        mimeMessage.setContent(allFile);
        mimeMessage.saveChanges();//保存修改
        return mimeMessage;
    }
}
