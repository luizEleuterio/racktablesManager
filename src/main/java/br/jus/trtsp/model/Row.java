package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Row database table.
 * 
 */

@Entity
@Table(name="Row")
public class Row implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(name="location_id")
	private int locationId;

	@Column(name="location_name", columnDefinition="char(255)")
	private String locationName;

	@Column(columnDefinition="char(255)")
	private String name;

	public Row() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
