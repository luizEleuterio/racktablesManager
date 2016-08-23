package br.jus.trtsp.control;

import br.jus.trtsp.dao.AttributeValueDAO;
import br.jus.trtsp.model.AttributeValue;
import br.jus.trtsp.model.AttributeValuePK;

public class AttributeValueControl {

	public AttributeValue incluir(AttributeValue attributeValue) {
		AttributeValueDAO dao = new AttributeValueDAO();
		AttributeValue av = (AttributeValue) dao.incluir(attributeValue);
		dao.close();
		return av;
		
	}

	public AttributeValue incluirModeloSwitch(int objectId, int dictKey) {
		AttributeValuePK avpk = new AttributeValuePK();
		avpk.setAttrId(2); //Attribute 2 - Modelo Switch
		avpk.setObjectId(objectId);
		AttributeValue av = new AttributeValue();
		av.setId(avpk); 
		av.setUintValue(dictKey);
		av.setObjectTid(8); //ObjTypeId 8 - Switch
		av = incluir(av);
		return av;
	}

	public AttributeValue incluirSerie(int objectId, String serie) {
		AttributeValuePK avpk = new AttributeValuePK();
		avpk.setAttrId(1); //Attribute 1 - Serial
		avpk.setObjectId(objectId);
		AttributeValue av = new AttributeValue();
		av.setId(avpk);
		av.setObjectTid(8); //ObjTypeId 8 - Switch
		av.setStringValue(serie);
		av = incluir(av);
		return av;
	}

	public AttributeValue incluirContratoTRT(int objectId, String contratoTrt) {
		AttributeValuePK avpk = new AttributeValuePK();
		avpk.setAttrId(10000); //Attribute 10000 - CT
		avpk.setObjectId(objectId);
		AttributeValue av = new AttributeValue();
		av.setId(avpk); 
		av.setObjectTid(8); //ObjTypeId 8 - Switch
		av.setStringValue(contratoTrt);
		av = incluir(av);
		return av;
	}

	public AttributeValue incluirPgCtPa(int objectId, String pg_ct_pa) {
		AttributeValuePK avpk = new AttributeValuePK();
		avpk.setAttrId(10003);//Attribute 10003 - PGCTPA
		avpk.setObjectId(objectId);
		//prepara atributo - pg_cd_pa
		AttributeValue av = new AttributeValue();
		av.setId(avpk);
		av.setObjectTid(8); //ObjTypeId 8 - Switch
		av.setStringValue(pg_ct_pa);
		av = incluir(av);
		return av;
		
	}

	public AttributeValue incluirFornecedor(int objectId, String fornecedor) {
		AttributeValuePK avpk = new AttributeValuePK();
		avpk.setAttrId(10006);//Attribute 10006 - Fornecedor
		avpk.setObjectId(objectId);
		//prepara atributo - Fornecedor
		AttributeValue av = new AttributeValue();
		av.setId(avpk); 
		av.setObjectTid(8); //ObjTypeId 8 - Switch
		av.setStringValue(fornecedor);
		av = incluir(av);
		return av;
	}

}

