package com.dsr.admissions.ms.model;

public class Disease {

	private String Id;
	private String description;
	private String treatment;
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Override
	public String toString() {
		return "Disease [Id=" + Id + ", description=" + description + ", treatment=" + treatment + "]";
	}

	public Disease(String id, String description, String treatment) {
		super();
		Id = id;
		this.description = description;
		this.treatment = treatment;
	}

	public Disease() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
