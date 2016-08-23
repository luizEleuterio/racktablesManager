package br.jus.trtsp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.jus.trtsp.model.ObjectHistory;

public class ObjectHistoryDAOTest {

	@Test
	public void consultarPorId(){
		ObjectHistoryDAO dao = new ObjectHistoryDAO();
		List<ObjectHistory> ohlist = new ArrayList<ObjectHistory>();
		try {
			ohlist = dao.consultarPorId(703);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(ObjectHistory oh: ohlist){
			System.out.println(oh);
		}
		
		
	}
	
	@Test
	public void inserir(){
		ObjectHistoryDAO dao = new ObjectHistoryDAO();
		List<ObjectHistory> ohlist = new ArrayList<ObjectHistory>();
		try {
			ohlist = dao.consultarPorId(703);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ObjectHistory oh = ohlist.get(0);
		System.out.println(oh.getId());
		oh.setCtime(null);
		oh.setUserName("l166049");
		oh.setLabel("TESTE");
		try {
			dao.inserir(oh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
