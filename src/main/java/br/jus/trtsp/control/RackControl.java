package br.jus.trtsp.control;

import java.util.List;

import br.jus.trtsp.dao.RackDAO;
import br.jus.trtsp.model.Rack;

public class RackControl {

	public Rack encontrarRackPorLocationIdDescricao(int locationId, String descricao){
		RackDAO rdao = new RackDAO();
		List<Rack> racks = rdao.encontrarRacksPorLocationIdDescricao(locationId,descricao);
		rdao.close();
		Rack r = null;
		if(racks.size() == 1){
			r = racks.get(0);
		}
		return r;
	}
		
}
