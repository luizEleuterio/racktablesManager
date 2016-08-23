package br.jus.trtsp.dao;

import org.junit.Test;

import junit.framework.Assert;

public class IPv4AddressDAOTest {
	
	@Test
	public void converteIpBytes(){
		IPv4AddressDAO dao = new IPv4AddressDAO();
		int ipbytes = dao.converteIPBytes("10.2.1.40");
		System.out.println(ipbytes);
		Assert.assertEquals(167903528, ipbytes);
	} 
	
	@Test
	public void converteBytesIP(){
		IPv4AddressDAO dao = new IPv4AddressDAO();
		String bytesIp = dao.converteBytesIP(167903528);
		System.out.println(bytesIp);
		Assert.assertEquals("10.2.1.40", bytesIp);
	} 
}
