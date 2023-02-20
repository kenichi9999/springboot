package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str,@RequestParam("text2") String str2, Model model) {
		
		//画面から受け取った文字列をModelに登録
		model.addAttribute("sample",str + str2 );
		model.addAttribute("sample2",str2);
		return "hello/response";
		
	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("textdb") String id, Model model) {
		Employee employee = service.getEmployee(id);
		
		model.addAttribute("employee", employee);
		return "hello/db";
	}
	

}
