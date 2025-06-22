package site.webzank.rent.service.impl;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author zank
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String username;

    public void sendMail(String to, int code) throws Exception, UnsupportedEncodingException {
        log.info("发送邮件开始");
        log.info("收件人：{}", to);
        log.info("验证码：{}", code);
        // 创建一个邮件消息
        MimeMessage message = mailSender.createMimeMessage();

        String content = """
                <!DOCTYPE html>
                <html lang="zh-CN">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>咕咕租房 - 验证码</title>
                </head>
                <body style="margin: 0; padding: 0; font-family: 'Helvetica Neue', Arial, sans-serif; background-color: #f7f7f7; color: #333333;">
                    <div style="max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);">
                        <!-- 标题栏 -->
                        <div style="text-align: center; padding: 20px 0; border-bottom: 1px solid #eeeeee;">
                            <h1 style="color: #1B81F6; margin: 0; font-size: 24px;">咕咕租房</h1>
                            <p style="color: #888888; margin: 5px 0 0;">让租房更简单</p>
                        </div>
                       \s
                        <!-- 正文 -->
                        <div style="padding: 30px 20px;">
                            <p style="font-size: 16px; line-height: 1.6; margin-bottom: 20px;">尊敬的用户，您好！</p>
                            <p style="font-size: 16px; line-height: 1.6; margin-bottom: 20px;">感谢您使用咕咕租房APP。您正在进行邮箱验证，请在验证码输入框中输入以下验证码完成验证：</p>
                           \s
                            <!-- 验证码展示 -->
                            <div style="background-color: #f5f7fa; border-radius: 6px; text-align: center; padding: 15px; margin: 25px 0;">
                                <p style="font-size: 32px; letter-spacing: 5px; font-weight: bold; color: #1B81F6; margin: 0;">
                """
                + code +
                """
                                    </p>
                                    </div>
                                   \s
                                    <!-- 提示信息 -->
                                    <p style="font-size: 14px; line-height: 1.6; color: #666666; margin-bottom: 10px;">• 验证码有效期为<span style="color: #1B81F6; font-weight: bold;">5分钟</span>，请尽快完成验证。</p>
                                    <p style="font-size: 14px; line-height: 1.6; color: #666666; margin-bottom: 10px;">• 如非本人操作，请忽略此邮件，并及时修改您的账户密码。</p>
                                    <p style="font-size: 14px; line-height: 1.6; color: #666666; margin-bottom: 20px;">• 请勿将验证码泄露给他人，咕咕租房不会以任何理由要求您提供验证码。</p>
                                   \s
                                    <p style="font-size: 16px; line-height: 1.6; margin-top: 30px;">祝您租房愉快！</p>
                                    <p style="font-size: 16px; line-height: 1.6; margin-bottom: 0;">咕咕租房团队</p>
                                </div>
                               \s
                                <!-- 页脚 -->
                                <div style="text-align: center; border-top: 1px solid #eeeeee; padding-top: 20px; font-size: 12px; color: #999999;">
                                    <p style="margin-bottom: 10px;">此邮件由系统自动发送，请勿直接回复</p>
                                    <p style="margin: 0;">如有问题，请联系客服：www.webzank.site</p>
                                </div>
                            </div>
                        </body>
                        </html>\s
                        """;

        // 创建 MimeMessageHelper
        MimeMessageHelper helper = new MimeMessageHelper(message, false);

        // 发件人邮箱和名称
        helper.setFrom(username, "咕咕租房");
        // 收件人邮箱
        helper.setTo(to);
        // 邮件标题
        helper.setSubject("验证码登录");
        // 邮件正文，第二个参数表示是否是HTML正文
        helper.setText(content, true);

        // 发送
        mailSender.send(message);
        log.info("发送邮件结束");

    }
}
