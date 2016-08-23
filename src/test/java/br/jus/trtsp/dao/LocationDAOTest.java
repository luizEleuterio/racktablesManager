package br.jus.trtsp.dao;

import org.junit.Test;

import br.jus.trtsp.model.Location;

public class LocationDAOTest {

	@Test
	public void buscaPorStringTest(){
		LocationDAO ldao = new LocationDAO();
		Location l = ldao.pesquisarPorString("UA02 terreo");
		System.out.println(l);
	}
	
}
