package com.rk.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.rk.mail.MailService;

@Component
public class MessageAppRunner implements CommandLineRunner {
	@Autowired
	private MailService mail;
	Resource file = new FileSystemResource("C:\\Users\\Ravikant\\Desktop\\rk.jpg");

	@Override
	public void run(String... args) throws Exception {
		boolean sent = mail.send("satishkushwah48@gmail.com",
				new String[] { "oayodele111@gmail.com", "venkatesh.jcn@gmail.com" },
				new String[] { "ashwinsharma4444@gmail.com", "sudheermanig430@gmail.com" },
				"Welcome To Rk Technologies", "Hello Good Evening", file);
		if (sent) {
			System.out.println("!Mail Sent");
		} else {
			System.out.println("Not Sent");
		}
	}

}
