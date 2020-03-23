package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.CartVo;

@Repository
public class CartDao {
	public static int insertCart(CartVo c) {
		return DBManager.insertCart(c);
	}

}
