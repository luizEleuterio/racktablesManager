package br.jus.trtsp.control;

import org.junit.Test;

import br.jus.trtsp.model.Rack;

public class RackControlTest {
	@Test
	public void encontrarRacksPorLocationIdDescricaoTest(){
		RackControl rctrl = new RackControl();
		Rack r = rctrl.encontrarRackPorLocationIdDescricao(1721,"Huawei");
		System.out.println(r);
	}
}
