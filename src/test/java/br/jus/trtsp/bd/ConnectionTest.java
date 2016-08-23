package br.jus.trtsp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void testaConexao(){
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://10.2.36.170/racktables_db","root","pl89e6hj3");
			if(!c.isClosed()){
				System.out.println("Conexao Aberta");
			
				PreparedStatement ps = c.prepareStatement("Select * from Attribute");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					System.out.println(rs.getString(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
				}
				c.close();
				System.out.println("Conexao Fechada");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
