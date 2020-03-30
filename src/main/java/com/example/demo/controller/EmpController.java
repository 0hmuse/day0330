package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.vo.EmpVo;

@RestController
public class EmpController {
	
	@Autowired
	private MailSender javaMailSender;
	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private EmpDao dao;		
	public EmpDao getDao() {
		return dao;
	}
	
	//@Scheduled(fixedRate = 5000)
	//@Scheduled(cron = "0 39 16 30 * ?")	
	public void pro() {
		List<EmpVo> list = dao.listAll();
		
		for(EmpVo emp : list) {
			String email = emp.getEmail();
			int pay = emp.getSal() + emp.getComm();
			//int comm = emp.getComm();
			String ename = emp.getEname();
			
			SimpleMailMessage mailMSG = new SimpleMailMessage();
			mailMSG.setSubject("이번달 급여");
			mailMSG.setFrom("88.hmuse@gmail.com");
			mailMSG.setText(ename + "님의 이번달 급여는" + pay + "입니다.");
			mailMSG.setTo(email);
			try {
				javaMailSender.send(mailMSG);
				System.out.println("메일보내기완료");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}			
		}
	}	
}
