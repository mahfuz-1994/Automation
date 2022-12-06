package com.example.automation.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.automation.DAO.AutomationDAO;
import com.example.automation.JDBC.ConnectionFact;
import com.example.automation.Model.BotModel;
import com.example.automation.Model.DepartmentModel;
import com.example.automation.Repository.DashboardRepo;
import com.example.automation.Repository.DepartmentRepository;
import com.example.automation.Service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/DepartmentController1")
public class DepartmentController {
	
	Connection connection = null;
	PreparedStatement ptmt = null; 
	ResultSet resultSet = null;
	 
	@Autowired
	
	private DepartmentRepository departmentrepository;
	
	@Autowired
	private DepartmentRepository departmentRepos;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFact.getInstance().getConnection();
		return conn;
		
	}
	
	private static EntityManagerFactory entityManagerFactory =
	          Persistence.createEntityManagerFactory("automation");
	

			@RequestMapping(value="/AllDepartment", method = RequestMethod.GET)
			public String fetchDepartments() {
				return departmentrepository.fetchDepartment();
			  }
			@GetMapping(path = "/DepartmentDetails", produces = "application/json")
			public String getDeparrmentString()
		    {
				return "";
			}


//Comment Post Method Start

@PostMapping(path = "/PostInsertDepartmentData", consumes = "application/json", produces = "application/json")
public String PostDataChartResponse(			
		@RequestBody String postData) throws Exception {
		System.out.print(postData);
		
		List<String> data1 = new ArrayList<String>();
		JSONArray ja1 = new JSONArray();			
		try {
					
					EntityManager entityManager = entityManagerFactory.createEntityManager();
		      StoredProcedureQuery procedureQuery =
		              entityManager.createNamedStoredProcedureQuery(DepartmentModel.NamedQuery_DepartmentInsertStoreProcedure);	
		   
		      entityManager.getTransaction().begin();
		      procedureQuery.setParameter("DepartmentId", 0);
		      procedureQuery.setParameter("DeaprtName","Deaprtment Name");
		      procedureQuery.setParameter("ActionType","Insert");
		      
		      procedureQuery.execute(); 
		      entityManager.getTransaction().commit();
		      entityManager.close();
		      //@SuppressWarnings("unchecked");
		      System.out.print("inserted successfully");
		     
		      
			
		      return "{    \r\n"
		      		+ "  			\"DepartmentId\" : \"Inserted Sucessfully\"\r\n"
		      		+ "  			}";		
		//}
		}catch (Exception e) {
		// TODO: handle exception
			return "Somthing went Wrong";
		}
		
	

}


// Comment post method end

}




