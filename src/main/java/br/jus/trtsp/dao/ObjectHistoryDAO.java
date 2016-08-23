package br.jus.trtsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.jus.trtsp.model.ObjectHistory;

public class ObjectHistoryDAO {
	
	//TODO Já que não consigo mapear a entidade por falta de pk, não utilizar o EntityManager, tentar com PreparedStatement...
	public void inserir(ObjectHistory oh) throws SQLException{
		
		String sql = "insert into ObjectHistory  ("
				+ "id, "
				+ "name, "
				+ "label, "
				+ "objtype_id, "
				+ "asset_no, "
				+ "has_problems, "
				+ "comment, "
				+ "user_name "
				+ ") VALUES (?,?,?,?,?,?,?,?)";
						
		
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, oh.getId());
		pstmt.setString(2, oh.getName());
		pstmt.setString(3, oh.getLabel());
		pstmt.setInt(4, oh.getObjtypeId());
		pstmt.setString(5, oh.getAssetNo());
		pstmt.setString(6, oh.getHasProblems());
		pstmt.setString(7, oh.getComment());
		pstmt.setString(8, oh.getUserName());
		
		pstmt.execute();
		
		pstmt.close();
		conn.close();
	}

		
		
	public List<ObjectHistory> consultarPorId(long ObjectHistoryId) throws SQLException{
		String sql = "SELECT "
				+ "id, "
				+ "name, "
				+ "label, "
				+ "objtype_id, "
				+ "asset_no, "
				+ "has_problems, "
				+ "comment, "
				+ "user_name "
				+ "FROM ObjectHistory "
				+ "WHERE id = "+ObjectHistoryId;
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ObjectHistory> objectHistories = new ArrayList<ObjectHistory>();
		ObjectHistory oh;
		while(rs.next()){
			oh = new ObjectHistory(
				rs.getInt("id"),
				rs.getString("asset_no"),
				rs.getString("comment"),
				rs.getString("has_problems"),
				rs.getString("label"),
				rs.getString("name"),
				rs.getInt("objtype_id"),
				rs.getString("user_name")
			);
			objectHistories.add(oh);
		}
		rs.close();
		pstmt.close();
		conn.close();
	
		return objectHistories;
	}
	
	
}
