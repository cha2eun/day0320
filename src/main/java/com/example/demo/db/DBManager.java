package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CartVo;
import com.example.demo.vo.ChatVo;
import com.example.demo.vo.EventVo;
import com.example.demo.vo.GoodsVo;
import com.example.demo.vo.MemberVo;


public class DBManager {
	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
	}
	public static MemberVo isMember(MemberVo m) {
		MemberVo r = null;
		SqlSession session = factory.openSession();
		r=session.selectOne("member.isMember",m);
		session.close();
		return r;
	}
	public static int insertCart(CartVo c) {
		SqlSession session = factory.openSession(true);
		int re = -1;
		re=session.insert("cart.insert",c);
		session.close();
		return re;
	}
	public static int insertEvent(EventVo e) {
		SqlSession session = factory.openSession(true);
		int re = -1;
		re=session.insert("event.insert",e);
		session.close();
		return re;
	}
	public static List<EventVo> listEvent(){
		SqlSession session = factory.openSession();
		List<EventVo> list = session.selectList("event.selectAll");
		session.close();
		return list;
	}
	public static List<ChatVo> listChat(){
		SqlSession session = factory.openSession();
		List<ChatVo> list = session.selectList("chat.selectAll");
		session.close();
		return list;
	}
	public static int insertChat(ChatVo c) {
		SqlSession session = factory.openSession(true);
		int re = -1;
		re=session.insert("chat.insert",c);
		session.close();
		return re;
	}
	
	public static List<GoodsVo> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	
}

