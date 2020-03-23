package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.EventVo;
import com.google.gson.Gson;

@RestController
public class EventController {
	@RequestMapping(value = "/eventList",produces = "application/json;charset=UTF-8")
	public String  listEvent() {
		String str="";
		str=new Gson().toJson(DBManager.listEvent());
		return str;
	}
	
	@RequestMapping(value = "/eventInsert",produces = "application/json;charset=UTF-8")
	public String insertEvent(EventVo e) {
		String str ="";
		DBManager.insertEvent(e);
		return str;
	}
}
