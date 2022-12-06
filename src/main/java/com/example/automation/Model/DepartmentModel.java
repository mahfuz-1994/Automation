package com.example.automation.Model;

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
	      name = DepartmentModel.NamedQuery_DepartmentStoreProcedure,
	      procedureName = "get_TblDeaprtment"
	      )




@NamedStoredProcedureQuery(
		name = DepartmentModel.NamedQuery_DepartmentInsertStoreProcedure,
	      procedureName = "Usp_Insert_Department",
	    		  parameters = {
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "DepartmentId", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "DepartmentName", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "CreatedBy", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "UpdatedBy", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "ActionType", type = String.class) })
	      



@Entity
@Table(name="tbl_Department")
public class DepartmentModel {
	
	public static final String NamedQuery_DepartmentNameStoreProcedure = "DepartmentStoreProcedure";
	public static final String NamedQuery_DepartmentStoreProcedure = "DepartmentAllStoreProcedure";
	public static final String NamedQuery_DepartmentInsertStoreProcedure = "DepartmentInsertStoreProcedure";

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
	@Column(name = "DepartmentId")
	private int id;
	
	@Column(name = "DepartmentName")
	private String DepartmentName;

	public DepartmentModel(int id, String departmentName) {
		super();
		this.id = id;
		DepartmentName = departmentName;
	}

	public DepartmentModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", DepartmentName=" + DepartmentName + "]";
	}

}
