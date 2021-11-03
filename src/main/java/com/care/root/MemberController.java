package com.care.root;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	//@Inject //inject와 autowired 둘 다 사용 가능. 
	@Autowired
	@Qualifier("mmm")
	MemberService ms;
	
	@RequestMapping("insert")
	public String insert(Model model) {
		//ms = new MemberService();
		int result = ms.insert();
		//ms.insert(); //에러
		System.out.println("ms : " + ms);
		model.addAttribute("result", result);
		return "di/index";
	}
	
}
