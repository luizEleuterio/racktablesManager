package br.jus.trtsp.dao;

import java.util.List;

import org.junit.Test;

import br.jus.trtsp.model.Dictionary;

public class DictionaryDAOTest {

	
	@Test
	public void getModelosNetworkSwitchTest(){
		DictionaryDAO dao = new DictionaryDAO();
		List<Dictionary> lista = dao.getModelosNetworkSwitch();
		for(Dictionary d:lista){
			System.out.println(d.getDictValue());
		}
	}
	
}
