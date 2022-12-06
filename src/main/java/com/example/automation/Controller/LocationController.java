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
import org.springframework.web.servlet.ModelAndView;

import com.example.automation.JDBC.ConnectionFact;
import com.example.automation.Model.DepartmentModel;
import com.example.automation.Model.LocationModel;
import com.example.automation.Repository.DepartmentRepository;
import com.example.automation.Repository.LocationRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping(path = "/LocationController")
public class LocationController {
	
	Connection connection = null;
	PreparedStatement ptmt = null; 
	ResultSet resultSet = null;
	

	
	 
	@Autowired
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFact.getInstance().getConnection();
		return conn;
		
	}
	
	private static EntityManagerFactory entityManagerFactory =
	          Persistence.createEntityManagerFactory("automation");
	
	
	@GetMapping(path = "/LocationDetails", produces = "application/json")
	public String getLocationString()
    {
		return "";
	}

	


//Comment Post Method Start

@PostMapping(path = "/PostInsertLocationData", consumes = "application/json", produces = "application/json")
public String PostDataChartResponse(			
	@RequestBody String postData) throws Exception {
	System.out.print(postData);
	
	List<String> data1 = new ArrayList<String>();
	JSONArray ja1 = new JSONArray();			
	try {
				
				EntityManager entityManager = entityManagerFactory.createEntityManager();
	      StoredProcedureQuery procedureQuery =
	              entityManager.createNamedStoredProcedureQuery(LocationModel.NamedQuery_LocationInsertStoreProcedure
	            		   );	
	   
	      entityManager.getTransaction().begin();
	      procedureQuery.setParameter("LocayionId", 0);
	      procedureQuery.setParameter("LocationName","Location Name");
	      procedureQuery.setParameter("ActionType","Insert");
	      
	      procedureQuery.execute(); 
	      entityManager.getTransaction().commit();
	      entityManager.close();
	      //@SuppressWarnings("unchecked");
	      System.out.print("inserted successfully");
	     
	      
		
	      return "{    \r\n"
	      		+ "  			\"LocationId\" : \"Inserted Sucessfully\"\r\n"
	      		+ "  			}";		
	//}
	}
	catch (Exception e) {
	// TODO: handle exception
		return "Somthing went Wrong";

// Comment post method end

	}
	}


@GetMapping(path = "/GetLocationListData", produces = "application/json")
	public String getlocationString()
    {
		List<String> data = new ArrayList<String>();
		JSONArray ja1 = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
		      StoredProcedureQuery procedureQuery =
		              entityManager.createNamedStoredProcedureQuery(LocationModel.NamedQuery_LocationListStoreProcedure);		      
		      procedureQuery.execute(); 
		      @SuppressWarnings("unchecked")
		      List<Object[]> resultList = procedureQuery.getResultList();
		      for (Object[] r : resultList) {
		    	  System.out.print(r[0]);
		    	  System.out.print(r[1]);
		    	  JSONObject obj1 = new JSONObject();		 
		    	  obj1.put("LocationId",r[0]);
				  obj1.put("LocationName",r[1]);
				  obj1.put("CreatedDate",r[2]);			
				  obj1.put("CreatedBy",r[3]);
				  obj1.put("UpdatedDate",r[4]);
				  obj1.put("UpdatedBy",r[5]);
				  obj1.put("IsActive",r[6]);
				  ja1.add(obj1); 
		      
		      }
		     
			
		     return ja1.toString();
		     // return "Developer";
		
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;	
	}
}