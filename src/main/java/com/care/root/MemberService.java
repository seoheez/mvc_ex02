package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mmm")
public class MemberService {
	@Autowired //자동적으로 주입해서 쓴다.
	MemberDAO dao; 
	public MemberService() {
		System.out.println("서비스 생성자 실행!");
	}
	public int insert() {
		//dao = new MemberDAO();
		System.out.println("dao : " + dao);
		return dao.insert();
		
	}
}
