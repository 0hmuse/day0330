package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlComtroller {
	
	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}	
	@RequestMapping("/send.do")	
	public void mail2() {
		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws MessagingException{
				MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				msg.setFrom("88.hmuse@gmail.com"); 
				msg.setTo("rola70@nate.com"); 
				msg.setSubject("html형식으로 메일보내기-하지연"); 
				
				String str = "<h2>html형식으로 메일보내기-ball1</h2><hr>";
				str += "<img src='cid:logo'>";
				
				msg.setText(str, true);
				msg.addInline("logo", new ClassPathResource("static/img/ball1.jpg"));
			}
		});		
		System.out.println("메일보내기완료");
	}
}
