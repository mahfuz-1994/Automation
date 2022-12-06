package com.example.automation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;


@NamedStoredProcedureQuery(
	      name = LoginModel.NamedQuery_LoginStoreProcedure,
	      procedureName = "Usp_LoginD",
	    		  parameters = {
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pusername", type = String.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "ppassword", type = String.class),
	    	              })


@Entity
@Table(name="login")
public class LoginModel {
	
		 public static final String NamedQuery_LoginStoreProcedure = "LoginStoreProcedure";

	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginModel(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public LoginModel(){
		super();
		// TODO Auto-generated constructor stub
	}
	
}
