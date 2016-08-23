package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.Location;

public class LocationDAO extends GenericDAO{

	public LocationDAO() {
		super("racktables_db");
	}
	
	
	
	public Location pesquisarPorString(String localizacaoPlanilha){
		String query = "select l from Location l where lower(l.name) like lower('%"+localizacaoPlanilha+"%')";
		Location l = null;
    	List<Location> lista = em.createQuery(query.toString(), Location.class).getResultList();
		if(lista.size() == 1){
			l = lista.get(0);
		}else{
			l = null;
		}
    	return l; 
	}
}
