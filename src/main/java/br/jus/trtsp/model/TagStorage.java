package br.jus.trtsp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TagStorage")
public class TagStorage implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TagStoragePK id;
	
	@Column(name="tag_is_assignable", columnDefinition="enum(1)")
	private String tagIsAssignable;
	
	@Column(name="user", columnDefinition="char(64)")
	private String user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

		
	public TagStorage() {
		this.tagIsAssignable = "yes";
		this.date = new Date();
	}

	public TagStorage(TagStoragePK id, String user) {
		super();
		this.id = id;
		this.user = user;
		this.tagIsAssignable = "yes";
		this.date = new Date();
	}

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public TagStoragePK getId() {
		return id;
	}

	public void setId(TagStoragePK id) {
		this.id = id;
	}
}

