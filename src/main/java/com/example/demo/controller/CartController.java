package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CartDao;
import com.example.demo.vo.CartVo;
import com.google.gson.Gson;

@RestController
public class CartController {
	@Autowired
	public CartDao dao;

	public void setDao(CartDao dao) {
		this.dao = dao;
	}
	@RequestMapping(value = "insertCart",produces = "application/json;charset=UTF-8")
	public String insertCart(CartVo c) {
		String str="등록실패";
		int re=dao.insertCart(c);
		if(re>0)
			str="등록성공";
		str = new Gson().toJson(str);
		return str;
	}
	
}
