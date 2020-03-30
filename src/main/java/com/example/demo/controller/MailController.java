package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MailController {
	
	@Autowired
	private MailSender javaMailSender;

	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}	
	
	@RequestMapping("/mail.do")
	public String mail() {
		
		String r = "";
		SimpleMailMessage mailMSG = new SimpleMailMessage();
		mailMSG.setSubject("메일보냄");
		mailMSG.setFrom("88.hmuse@gmail.com");
		mailMSG.setText("오늘은 '메일발송하기' 실습하자");
		mailMSG.setTo("hajigoun@naver.com");
		try {
			javaMailSender.send(mailMSG);
			System.out.println("메일보내기완료");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}		
		return r;
	}
}
