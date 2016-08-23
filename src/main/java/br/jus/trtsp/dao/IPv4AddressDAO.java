package br.jus.trtsp.dao;

import java.math.BigInteger;

public class IPv4AddressDAO extends GenericDAO {

	public IPv4AddressDAO() {
		super("racktables_db");
	}
	
	public int converteIPBytes(String ip){
		String query = "select INET_ATON('"+ip+"') from dual;";
		BigInteger ipBytes = (BigInteger) em.createNativeQuery(query).getSingleResult();
		return ipBytes.intValue();
	}
	
	public String converteBytesIP(int bytes){
		String query = "select INET_NTOA('"+bytes+"') from dual;";
		String bytesIp = (String) em.createNativeQuery(query).getSingleResult();
		return bytesIp;
	}
	
}
