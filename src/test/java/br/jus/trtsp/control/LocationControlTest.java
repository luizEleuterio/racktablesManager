package br.jus.trtsp.control;

import org.junit.Test;

import br.jus.trtsp.model.Location;

public class LocationControlTest {

	@Test
	public void encontrarPorDescricaoTest(){
		LocationControl ctrl = new LocationControl();
		Location l = ctrl.pesquisarPorString("UA02 Andar 2");
		System.out.println(l);
	}
	
}
