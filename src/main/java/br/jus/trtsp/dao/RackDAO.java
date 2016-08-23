package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.Rack;

public class RackDAO extends GenericDAO{

	public RackDAO() {
		super("racktables_db");
	}

	public List<Rack> encontrarRacksPorLocationId(int locationId){
		String q = "select r from Rack r where r.locationId = '"+locationId+"'";
    	List<Rack> lista = em.createQuery(q.toString(), Rack.class).getResultList();
    	return lista;
	}
	
	public List<Rack> encontrarRacksPorLocationIdDescricao(int locationId, String descricao){
		String q = "select r from Rack r where r.locationId = '"+locationId+"' and (r.rowName like '%"+descricao+"%' or r.name like '%"+descricao+"%')";
		Rack r = null;
    	List<Rack> lista = em.createQuery(q.toString(), Rack.class).getResultList();
    	return lista;
	}	
	
}
