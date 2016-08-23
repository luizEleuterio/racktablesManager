package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ObjectLog database table.
 * 
 */

@Entity
@Table(name="ObjectLog")
@NamedQuery(name="ObjectLog.findAll", query="SELECT o FROM ObjectLog o")
public class ObjectLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, columnDefinition="text")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, columnDefinition="char(64)")
	private String user;

	//bi-directional many-to-one association to Object
	@ManyToOne
	@JoinColumn(name="object_id", nullable=false)
	private Object object;

	public ObjectLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
