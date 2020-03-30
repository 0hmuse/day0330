package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.MemberVo;

@Repository
public class MemberDao {

	public int insert(MemberVo m){
		return MemberManager.insert(m);
	}
}
