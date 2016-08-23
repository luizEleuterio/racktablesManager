package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RackSpace database table.
 * 
 */

@Embeddable
public class RackSpacePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="rack_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int rackId;

	@Column(name="unit_no", unique=true, nullable=false)
	private int unitNo;

	@Column(unique=true, nullable=false, columnDefinition="enum(1)")
	private String atom;

	public RackSpacePK() {
	}
	public int getRackId() {
		return this.rackId;
	}
	public void setRackId(int rackId) {
		this.rackId = rackId;
	}
	public int getUnitNo() {
		return this.unitNo;
	}
	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}
	public String getAtom() {
		return this.atom;
	}
	public void setAtom(String atom) {
		this.atom = atom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atom == null) ? 0 : atom.hashCode());
		result = prime * result + rackId;
		result = prime * result + unitNo;
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
		RackSpacePK other = (RackSpacePK) obj;
		if (atom == null) {
			if (other.atom != null)
				return false;
		} else if (!atom.equals(other.atom))
			return false;
		if (rackId != other.rackId)
			return false;
		if (unitNo != other.unitNo)
			return false;
		return true;
	}

	
}
