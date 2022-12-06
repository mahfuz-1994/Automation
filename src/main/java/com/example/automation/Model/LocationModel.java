package com.example.automation.Model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@NamedStoredProcedureQuery(
	      name = LocationModel.NamedQuery_LocationStoreProcedure,
	      procedureName = "get_TblLocation1"
	      )

@NamedStoredProcedureQuery(
	      name = LocationModel.NamedQuery_LocationListStoreProcedure,
	      procedureName = "Usp_LocationMst"
	      )


@NamedStoredProcedureQuery(
		name = LocationModel.NamedQuery_LocationInsertStoreProcedure,
	      procedureName = "Usp_Insert_Location",
	    		  parameters = {
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "LocationId", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "LocationName", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "CreatedBy", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "UpdatedBy", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "ActionType", type = String.class) })
	      

@Entity
@Table(name="tbl_Location")
public class LocationModel {
	
	
	public static final String NamedQuery_LocationNameStoreProcedure = "LocationStoreProcedure";
	public static final String NamedQuery_LocationStoreProcedure = "LocationAllStoreProcedure";
	public static final String NamedQuery_LocationInsertStoreProcedure = "LocationInsertStoreProcedure";
    public static final String NamedQuery_LocationListStoreProcedure = "LocationListStoreProcedure";

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
	 @Column(name = "LocationId")
	
	private int id;
	
	@Column(name = "LocationName")
	
	private String LocationName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocationName() {
		return LocationName;
	}
	public void setLocationName(String locationName) {
		LocationName = locationName;
	}
	@Override
	public String toString() {
		return "LocationModel [id=" + id + ", LocationName=" + LocationName + "]";
	}	

}
