package br.jus.trtsp.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the ObjectHistory database table.
 * Não pode ser entidade - impossível atribuir chave primária!!!
 */


public class ObjectHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;
	private String assetNo;
	private String comment;
	private Timestamp ctime;
	private String hasProblems;
	private String label;
	private String name;
	private int objtypeId;
	private String userName;


	
	
	
	public ObjectHistory(int id, String assetNo, String comment, String hasProblems, String label, String name,
			int objtypeId, String userName) {
		super();
		this.id = id;
		this.assetNo = assetNo;
		this.comment = comment;
		this.hasProblems = hasProblems;
		this.label = label;
		this.name = name;
		this.objtypeId = objtypeId;
		this.userName = userName;
	}

	
	
	@Override
	public String toString() {
		return "ObjectHistory [id=" + id + ", assetNo=" + assetNo + ", comment=" + comment + ", ctime=" + ctime
				+ ", hasProblems=" + hasProblems + ", label=" + label + ", name=" + name + ", objtypeId=" + objtypeId
				+ ", userName=" + userName + "]";
	}


	public String getAssetNo() {
		return this.assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public String getHasProblems() {
		return this.hasProblems;
	}

	public void setHasProblems(String hasProblems) {
		this.hasProblems = hasProblems;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getObjtypeId() {
		return this.objtypeId;
	}

	public void setObjtypeId(int objtypeId) {
		this.objtypeId = objtypeId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}