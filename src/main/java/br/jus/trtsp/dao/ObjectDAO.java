package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.Object;

public class ObjectDAO extends GenericDAO{

	public ObjectDAO() {
		super("racktables_db");
	}

	
	public br.jus.trtsp.model.Object encontrarPorIPString(String ipv4String){
		
		String q = "select * from Object where id = (Select object_id from IPv4Allocation where ip = INET_ATON('"+ipv4String+"'))";
		Object obj = (Object) em.createNativeQuery(q.toString(), Object.class).getSingleResult();
		return obj;
	}
	
	
	public br.jus.trtsp.model.Object encontrarPorIPBytes(int ipv4bytes){
		String q = "select * from Object where id = (Select object_id from IPv4Allocation where ip = '"+ipv4bytes+"')";
		Object obj = (Object) em.createNativeQuery(q.toString(), Object.class).getSingleResult();
		return obj;
	}
	
	
	public br.jus.trtsp.model.Object encontrarPorTombo(String tombo){
		Object obj = null;
		String q = "select o from Object o where o.assetNo = '"+tombo+"'";
    	List<Object> lista = em.createQuery(q.toString(), Object.class).getResultList();
		if(lista.size() == 1){
			obj = lista.get(0);
		}
    	return obj;
	}

	public br.jus.trtsp.model.Object encontrarPorNome(String nome){
		Object obj = null;
		String q = "select o from Object o where o.name = '"+nome+"'";
    	List<Object> lista = em.createQuery(q.toString(), Object.class).getResultList();
		if(lista.size() == 1){
			obj = lista.get(0);
		}
    	return obj;
	}
	
	
	public br.jus.trtsp.model.Object encontrarPorSerial(String serial){
		List<Object> listaObjetos = null;
		String q = "select o from Object o where o.id = (Select a.id.objectId from AttributeValue a where a.id.attrId = 1 and a.stringValue = '"+serial+"')";
		listaObjetos = em.createQuery(q.toString(), Object.class).getResultList();
		Object obj = null;
		if(listaObjetos.size() == 1){
			obj = listaObjetos.get(0);
		}
		return obj;
	}
	
	
	
	
	
}
