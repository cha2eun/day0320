package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLoginController {
	@RequestMapping(value = "/ActionWithData", produces = "text/plaine;charset=UTF-8")
	public String actionWithData(String name, int age) {
		String str="";
		System.out.println("ajax통신");
		System.out.println("이름:"+name+", 나이:"+age);
		str="<h2>로그인성공</h2>";
		return str;
	}
}
