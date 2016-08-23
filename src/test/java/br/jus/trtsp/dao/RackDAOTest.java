package br.jus.trtsp.dao;

import java.util.List;

import org.junit.Test;

import br.jus.trtsp.control.RackControl;
import br.jus.trtsp.model.Rack;

public class RackDAOTest {
	
	
	@Test
	public void encontrarRacksPorLocationId(){
		RackDAO rdao = new RackDAO();
		List<Rack> racks = rdao.encontrarRacksPorLocationId(1719);
		for(Rack r:racks){
			System.out.println(r);
		}
		
	}
	
	
	
	
}
