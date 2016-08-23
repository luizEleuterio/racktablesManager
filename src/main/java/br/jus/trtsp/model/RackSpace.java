package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RackSpace database table.
 * 
 */

@Entity
@Table(name="RackSpace")
public class RackSpace implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RackSpacePK id;

	@Column(nullable=false, columnDefinition="enum(1)")
	private String state;

	@Column(name="object_id")
	private Integer objectId;

	
	public RackSpace() {
		this.state = "T";
	}

	public RackSpacePK getId() {
		return this.id;
	}

	public void setId(RackSpacePK id) {
		this.id = id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

		
}
