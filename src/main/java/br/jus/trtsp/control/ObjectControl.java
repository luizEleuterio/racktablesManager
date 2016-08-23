package br.jus.trtsp.control;

import java.sql.SQLException;

import br.jus.trtsp.dao.ObjectDAO;
import br.jus.trtsp.dao.ObjectHistoryDAO;
import br.jus.trtsp.model.Object;
import br.jus.trtsp.model.ObjectHistory;

public class ObjectControl {

	public Object incluirSwitch(Object obj) {
		ObjectDAO dao = new ObjectDAO();
		obj = (Object) dao.incluir(obj);
		ObjectHistory oh = new ObjectHistory(obj.getId(), obj.getAssetNo(), obj.getComment(), obj.getHasProblems(), obj.getLabel(),obj.getName(),obj.getObjtypeId(),"l166049");
		ObjectHistoryDAO ohdao = new ObjectHistoryDAO();
		try {
			ohdao.inserir(oh);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.close();
		return obj;
	}

	public Object alterar(Object obj) {
		ObjectDAO dao = new ObjectDAO();
		Object o = (Object) dao.alterar(obj);
		dao.close();
		return o;
		
	}
	
	public Object encontrarPorId(int objId){
		ObjectDAO dao = new ObjectDAO();
		Object o = (Object) dao.encontrarPorId(objId, Object.class);
		dao.close();
		return o;
	}

	public Object encontrarPorSerie(String serie){
		ObjectDAO dao = new ObjectDAO();
		Object o = (Object) dao.encontrarPorSerial(serie);
		dao.close();
		return o;
	}
	
}
