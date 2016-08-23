package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AttributeValue database table.
 * 
 */
@Embeddable
public class AttributeValuePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="object_id", unique=true, nullable=false)
	private int objectId;

	@Column(name="attr_id", unique=true, nullable=false)
	private int attrId;

	public AttributeValuePK() {
	}
	public int getObjectId() {
		return this.objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	public int getAttrId() {
		return this.attrId;
	}
	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attrId;
		result = prime * result + objectId;
		return result;
	}
	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeValuePK other = (AttributeValuePK) obj;
		if (attrId != other.attrId)
			return false;
		if (objectId != other.objectId)
			return false;
		return true;
	}

	
}