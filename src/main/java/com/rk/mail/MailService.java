package com.rk.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	@Autowired
	private JavaMailSender sender;

	public boolean send(String to, String[] cc, String[] bcc, String subject, String text, Resource file) {
		boolean isSend = false;
		try {
			// create new MimeMessage
			MimeMessage message = sender.createMimeMessage();
			// User Helper class and fill details(to,cc ,bcc..etc)
			MimeMessageHelper helper = new MimeMessageHelper(message, file != null ? true : false);
			helper.setTo(to);
			if (cc != null)
				helper.setCc(cc);
			if (bcc != null)
				helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(text);
			if (file != null)
				helper.addAttachment(file.getFilename(), file);
			sender.send(message);
			isSend = true;
		} catch (Exception e) {
			isSend = false;
			e.printStackTrace();
		}
		return isSend;
	}
}
