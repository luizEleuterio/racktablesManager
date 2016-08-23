package br.jus.trtsp.dao;

import org.junit.Test;
import br.jus.trtsp.model.Object;

public class ObjectDAOTest {

	//@Test
	public void encontrarPorIPBytes(){
		ObjectDAO dao = new ObjectDAO();
		Object o = dao.encontrarPorIPBytes(167913513);
		System.out.println(o);
	}
	
	
	@Test
	public void encontrarPorIPString(){
		ObjectDAO dao = new ObjectDAO();
		Object o = dao.encontrarPorIPString("10.2.40.41");
		System.out.println(o);
	}
	
	@Test
	public void encontrarPorId(){
		ObjectDAO dao = new ObjectDAO();
		Object o = (Object) dao.encontrarPorId(1879, Object.class);
		System.out.println(o);
	}
		

	@Test
	public void encontrarPorSerial(){
		ObjectDAO dao = new ObjectDAO();
		Object o = (Object) dao.encontrarPorSerial("2102359576DMG2000126");
		System.out.println(o);
	}
}
