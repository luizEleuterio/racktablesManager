package br.jus.trtsp.control;

import org.junit.Test;

import br.jus.trtsp.model.Location;
import br.jus.trtsp.model.Object;
import br.jus.trtsp.model.Rack;

public class RackSpaceControlTest {

	
	@Test
	public void encontrarPrimeiroRackSpacePorRack(){
		RackSpaceControl rsc = new RackSpaceControl();
		int unidadeVazia = rsc.encontrarPrimeiraUnidadeVaziaPorRack(1739,42);
		System.out.println(unidadeVazia);
	}
	
	
	
	@Test
	public void adiocionarObjetoRackSpacesRack(){
		
		LocationControl lctrl = new LocationControl();
		Location l = lctrl.pesquisarPorString("FRB Andar 2");
		
		
		ObjectControl objctrl = new ObjectControl();
		Object o = objctrl.encontrarPorId(1811);
		
		RackControl rctrl = new RackControl();
		Rack rack = rctrl.encontrarRackPorLocationIdDescricao(l.getId(), "Bloco A");
		
		RackSpaceControl rsc = new RackSpaceControl();
		rsc.adicionarObjetoRackSpacesRack(o.getId(), rack.getId(), rack.getHeight());
	}
	
	
}
