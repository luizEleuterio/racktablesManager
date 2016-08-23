package br.jus.trtsp.control;

import org.junit.Test;

import junit.framework.Assert;

public class IPv4AddressControlTest {

	@Test
	public void converteBytesIP(){
		IPv4AddressControl ctrl = new IPv4AddressControl();
		String valor = ctrl.getIpv4Bytes(167903528);
		Assert.assertEquals("10.2.1.40", valor);
		System.out.println(valor);
	}
	
	@Test
	public void converteIPBytes(){
		IPv4AddressControl ctrl = new IPv4AddressControl();
		//int valor = ctrl.getBytesIpv4("10.2.1.40");
		int valor = ctrl.getBytesIpv4("10.2.40.41");
		System.out.println(valor);
		//Assert.assertEquals(167903528, valor);
		System.out.println(valor);
	}
	
}
