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
import com.example.automation.Model.BotModel;
import com.example.automation.Model.DepartmentModel;
import com.example.automation.Model.LocationModel;
import com.example.automation.Model.RealTimeModel;

import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping(path = "/BotNameValues")
public class BotNameController {
	
	@Autowired(required=false)
	
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
	

	@RequestMapping(value="/AllBotnameValue" , method= RequestMethod.GET)
	public String fetchBotNames() {
		//return ibotnamerepos.fetchBotName();
		return "BotName";
	}
	
	@GetMapping(path = "/GetBotNameDetails", produces = "application/json")
	public String getBotNameString()
    {
		List<String> data = new ArrayList<String>();
		JSONArray ja1 = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
		      StoredProcedureQuery procedureQuery =
		              entityManager.createNamedStoredProcedureQuery(BotModel.NamedQuery_BotAllStoreProcedure);		      
		      procedureQuery.execute(); 
		      @SuppressWarnings("unchecked")
		      List<Object[]> resultList = procedureQuery.getResultList();
		      for (Object[] r : resultList) {
		    	  System.out.print(r[0]);
		    	  System.out.print(r[1]);
		    	  JSONObject obj1 = new JSONObject();
				  obj1.put("BotId",r[0]);
				  obj1.put("BotName",r[1]);	
				  obj1.put("LocactionId",r[2]);
				  obj1.put("DepartmentId",r[3]);	
				  obj1.put("CreateDate",r[4]);
				  obj1.put("CreatedBy",r[5]);
				  obj1.put("UpdatedDate",r[6]);
				  obj1.put("UpdatedBy",r[7]);	
				  obj1.put("IsActive",r[8]);
				  ja1.add(obj1); 
		      
		      }
		     
			//return resultList;
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
	
	//Comment Post Method Start
	
	@PostMapping(path = "/PostInsertBotData", consumes = "application/json", produces = "application/json")
	public String PostDataChartResponse(			
			@RequestBody String postData) throws Exception {
			List<String> data1 = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();			
			try {
						
						EntityManager entityManager = entityManagerFactory.createEntityManager();
			      StoredProcedureQuery procedureQuery =
			              entityManager.createNamedStoredProcedureQuery(BotModel.NamedQuery_BotInsertStoreProcedure);	
			   
			      entityManager.getTransaction().begin();
			      procedureQuery.setParameter("BotId", 0);
			      procedureQuery.setParameter("BotName","Bot10");
			      procedureQuery.setParameter("LocationId",104);
			      procedureQuery.setParameter("DepartmentId",1);
			      procedureQuery.setParameter("CreatedBy","Sakshi");
			      procedureQuery.setParameter("UpdatedBy","Priyanka");
			      procedureQuery.setParameter("ActionType","Insert");
			      
			      procedureQuery.execute(); 
			      entityManager.getTransaction().commit();
			      entityManager.close();
			      //@SuppressWarnings("unchecked");
			      System.out.print("inserted successfully");
			     
			      
				
			      return "{    \r\n"
			      		+ "  			\"BotId\" : \"Inserted Sucessfully\"\r\n"
			      		+ "  			}";		
			//}
			}
			catch (Exception e) {
			// TODO: handle exception
				return "Somthing went Wrong";
			}
		
	}
	
	
	// Comment post method end
	
}
