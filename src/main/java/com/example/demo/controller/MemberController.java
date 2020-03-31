package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@RestController
public class MemberController {

	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	private MemberDao dao;
	public MemberDao getDao() {
		return dao;
	}
	
	@RequestMapping("/login.do")
	public String login(MemberVo m) {
		String str = "ok";
		
		String email = m.getEmail();
		String name = m.getName();
		
		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws MessagingException{
				MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				msg.setFrom("88.hmuse@gmail.com"); 
				msg.setTo(email); 
				msg.setSubject(name + "님 환영합니다"); 
				
				String str = "<h2>회원가입을 완료하시겠습니까?</h2><hr>";
				str += "<button>확인</button><button>취소</button>";
				
				msg.setText(str, true);
				
//				if(re == 1) {
//					dao.insert(m);
//				}else if(re == 0) {
//					
//				}
			}
		});		
		dao.insert(m);
		System.out.println("메일보내기완료");
		
		return str;
	}		
}
