package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.RackSpace;

public class RackSpaceDAO extends GenericDAO {

	public RackSpaceDAO() {
		super("racktables_db");
	}

	public List<RackSpace> encontrarRackSpacesPorRack(long rackId){
		String q = "select rs from RackSpace rs where rs.rackId = '%"+rackId+"%'";
    	List<RackSpace> lista = em.createQuery(q.toString(), RackSpace.class).getResultList();
    	return lista; 
	}
	
	
	public boolean verificaUnidadeVaziaPorRack(long rackId, long unidade){
		String q = "select rs from RackSpace rs "
				+ "where rs.id.rackId = '"+rackId+"' "
				+ "and rs.id.unitNo = '"+unidade+"'";
		
		List<RackSpace> lista = em.createQuery(q.toString(), RackSpace.class).getResultList();
    	return lista.size()  == 0;
	}

	
}


