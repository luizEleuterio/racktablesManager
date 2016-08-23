package br.jus.trtsp.control;

import java.util.ArrayList;
import java.util.List;

import br.jus.trtsp.dao.RackSpaceDAO;
import br.jus.trtsp.model.RackSpace;
import br.jus.trtsp.model.RackSpacePK;

public class RackSpaceControl {

	public RackSpace incluir(RackSpace rackSpace) {
		RackSpaceDAO rsdao = new RackSpaceDAO();
		RackSpace rs = (RackSpace) rsdao.incluir(rackSpace);
		rsdao.close();
		return rs;
	}

	public int encontrarPrimeiraUnidadeVaziaPorRack(int rackId, int tamanhoRack) {
		RackSpaceDAO rsdao = new RackSpaceDAO();
		int unidadeVazia = 0;
		for(int i = 1; i <= tamanhoRack; i++){
			if(rsdao.verificaUnidadeVaziaPorRack(rackId,i)){
				unidadeVazia = i;
				i = tamanhoRack + 1;
			}
		}
		rsdao.close();
		return unidadeVazia;
	}

	public RackSpace alterar(RackSpace rackSpace) {
		RackSpaceDAO rsdao = new RackSpaceDAO();
		RackSpace rs = (RackSpace) rsdao.alterar(rackSpace);
		rsdao.close();
		return rs;
		
	}
	
	
	public List<RackSpace> adicionarObjetoRackSpacesRack(int objectId, int rackId, int tamanhoRack) {
		List<RackSpace> rackspaces = new ArrayList<RackSpace>();
		RackSpaceDAO rsdao = new RackSpaceDAO();
		RackSpacePK rspk;
		RackSpace rs;
		
		int unidadeVazia = encontrarPrimeiraUnidadeVaziaPorRack(rackId,tamanhoRack);
		
		if(unidadeVazia > 0){
			//Incluir Front
			rspk = new RackSpacePK();
			rspk.setRackId(rackId);
			rspk.setUnitNo(unidadeVazia);
			rspk.setAtom("front");
			
			rs = new RackSpace();
			rs.setId(rspk);
			rs.setObjectId(objectId);
			rsdao.incluir(rs);
			rackspaces.add(rs);
				
			//Incluir Interior
			rspk = new RackSpacePK();
			rspk.setRackId(rackId);
			rspk.setUnitNo(unidadeVazia);
			rspk.setAtom("interior");
			
			rs = new RackSpace();
			rs.setId(rspk);
			rs.setObjectId(objectId);
			rsdao.incluir(rs);
			rackspaces.add(rs);
			
			//Incluir Rear
			rspk = new RackSpacePK();
			rspk.setRackId(rackId);
			rspk.setUnitNo(unidadeVazia);
			rspk.setAtom("rear");
			
			rs = new RackSpace();
			rs.setId(rspk);
			rs.setObjectId(objectId);
			rsdao.incluir(rs);
			rackspaces.add(rs);
			
			
		}
		rsdao.close();
		return rackspaces;
	}

}
