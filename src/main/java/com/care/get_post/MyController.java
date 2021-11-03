package com.care.get_post;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자 실행");
	}
	
	@RequestMapping(value="my/index", method = RequestMethod.GET)
	public String index() {
		return "/get_post/index";
	}//페이지에서 url로 요청하면 무조건 get방식
	
	@GetMapping("my/result")//위와 같은 get방식
	public String result_get(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("get방식으로 들어왔습니다");
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		
		model.addAttribute("method", request.getMethod() );
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/get_post/result";
	}
	//@PostMapping("my/result") //아래와 같은 post방식
	@RequestMapping(value="my/result", method = RequestMethod.POST)
	public String reuslt_post(HttpServletRequest request, Model model,
								@RequestParam("name") String name,
								@RequestParam("age") String age) {
		System.out.println("post방식으로 들어왔습니다");
		
		model.addAttribute("method", request.getMethod() );
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/get_post/result";
	}
}






