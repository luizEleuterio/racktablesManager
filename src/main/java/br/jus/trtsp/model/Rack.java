package br.jus.trtsp.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;


/**
 * The persistent class for the Rack database table.
 * 
 */
@Entity
@Table(name="Rack")
public class Rack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="asset_no", columnDefinition="char(64)")
	private String assetNo;

	@Column(columnDefinition="text")
	private String comment;

	@Column(name="has_problems", nullable=false, columnDefinition="enum(1)")
	private String hasProblems;

	@Column
	private int height;

	@Id
	@Column(nullable=false)
	private int id;

	@Column(name="location_id")
	private int locationId;

	@Column(name="location_name", columnDefinition="char(255)")
	private String locationName;

	@Column(columnDefinition="char(255)")
	private String name;

	@Column(name="row_id", nullable=false)
	private int rowId;

	@Column(name="row_name", columnDefinition="char(255)")
	private String rowName;

	@Column(name="sort_order")
	private int sortOrder;

	@Column(name="thumb_data", columnDefinition="blob")
	private byte[] thumbData;

	public Rack() {
	}

	
	@Override
	public String toString() {
		return "Rack [assetNo=" + assetNo + ", comment=" + comment + ", hasProblems=" + hasProblems + ", height="
				+ height + ", id=" + id + ", locationId=" + locationId + ", locationName=" + locationName + ", name="
				+ name + ", rowId=" + rowId + ", rowName=" + rowName + ", sortOrder=" + sortOrder + ", thumbData="
				+ Arrays.toString(thumbData) + "]";
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

	public String getHasProblems() {
		return this.hasProblems;
	}

	public void setHasProblems(String hasProblems) {
		this.hasProblems = hasProblems;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getRowName() {
		return this.rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public int getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public byte[] getThumbData() {
		return this.thumbData;
	}

	public void setThumbData(byte[] thumbData) {
		this.thumbData = thumbData;
	}

}