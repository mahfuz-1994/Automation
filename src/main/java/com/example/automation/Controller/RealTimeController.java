package com.example.automation.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.automation.Model.LoginModel;
import com.example.automation.Model.RealTimeModel;
import com.example.automation.Repository.RealTimeInterface;

@RestController
@RequestMapping(path = "/RealTimeDataValues")
public class RealTimeController {

	@Autowired(required=false) 
	private RealTimeInterface realtimedataRepos;
	//public iLocationRepos ilocationRepository;
	
	private static EntityManagerFactory entityManagerFactory =
	          Persistence.createEntityManagerFactory("automation");
	
	
	@RequestMapping(value="/AllRealTimeDataValue" , method= RequestMethod.GET)
	public List<RealTimeModel> getRealtimes(Integer LocationId, Integer Departmentid, Integer BotId) {
		//return realtimedataRepos.getRealTime(1,1,1);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	      StoredProcedureQuery procedureQuery =
	              entityManager.createNamedStoredProcedureQuery(RealTimeModel.NamedQuery_KhalidStoreProcedure);
	      procedureQuery.setParameter("pLocationId", 1);
	      procedureQuery.setParameter("pDepartmentId", 1);
	      procedureQuery.setParameter("pBotId", 1);
	      procedureQuery.execute(); 
	     // @SuppressWarnings("unchecked")
	      List<RealTimeModel> resultList = procedureQuery.getResultList();
		return resultList;
	}
	@PostMapping(path = "/PostGetDashboardGrid", consumes = "application/json", produces = "application/json")
	public String PostDataGridResponse(			
			@RequestBody String postData) throws Exception {
			List<String> data1 = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();			
			try {
				
				String[] arrOfStr = postData.split(",");
				String LocationId = ""+"'" + arrOfStr[0].toString() + "'";
				LocationId=LocationId.replace("\"", "");
				//System.out.print(LocationId + "Location");
				String DepartmentId = ""+"'" + arrOfStr[1].toString() + "'";
				DepartmentId=DepartmentId.replace("\"", "");
				//System.out.print(DepartmentId + "Department");
				String BotId = ""+"'" + arrOfStr[2].toString() + "'";
				BotId=BotId.replace("\"", "");
				//System.out.print(BotId + "BotId");
				
				EntityManager entityManager = entityManagerFactory.createEntityManager();
			      StoredProcedureQuery procedureQuery =
			              entityManager.createNamedStoredProcedureQuery(RealTimeModel.NamedQuery_KhalidStoreProcedure);	
			      LocationId = LocationId.replace("{LocationId:", "");
			      DepartmentId = DepartmentId.replace("DepartmentId:", "");
			      BotId = BotId.replace("BotId:", "").replace("}", "");
			      
			      LocationId = LocationId.replace("'","");
			      DepartmentId = DepartmentId.replace("'","");
			      BotId = BotId.replace("'","");
			   
			      procedureQuery.setParameter("pLocationId", Integer.parseInt(LocationId));
			      procedureQuery.setParameter("pDepartmentId", Integer.parseInt(DepartmentId));
			      procedureQuery.setParameter("pBotId", Integer.parseInt(BotId));
			      procedureQuery.setParameter("pType","Grid");
			      procedureQuery.setParameter("pSearch","");
			      
			      
			      procedureQuery.execute(); 
			      @SuppressWarnings("unchecked")
			      List<Object[]> resultList = procedureQuery.getResultList();
			      for (Object[] r : resultList) {
			    	  //System.out.print(r[1]);
			    	  //System.out.print(r[2]);
			    	  JSONObject obj1 = new JSONObject();
					  //obj1.put("total_Bot_count",r[0]);
					  obj1.put("ProcessId",r[0]);	
					  obj1.put("BotName",r[1]);
					  obj1.put("LocationName",r[2]);
					  obj1.put("DepartmentName",r[3]);
					  obj1.put("Process_Name",r[4]);
					  obj1.put("Status",r[5]);
					  obj1.put("Remarks",r[6]);
					  obj1.put("CreatedBy",r[7]);
					  
 
					  ja1.add(obj1); 
			      }
				
			      return ja1.toString();		
			//}
			}catch (Exception e) {
			// TODO: handle exception
			}
		return null;
	}
	
	@PostMapping(path = "/PostGetDashboardGridSearch", consumes = "application/json", produces = "application/json")
	public String PostDataGridSearchResponse(			
			@RequestBody String postData) throws Exception {
			List<String> data1 = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();			
			try {
				
				String[] arrOfStr = postData.split(",");
				String LocationId = ""+"'" + arrOfStr[0].toString() + "'";
				LocationId=LocationId.replace("\"", "");
				//System.out.print(LocationId + "Location");
				String DepartmentId = ""+"'" + arrOfStr[1].toString() + "'";
				DepartmentId=DepartmentId.replace("\"", "");
				//System.out.print(DepartmentId + "Department");
				String BotId = ""+"'" + arrOfStr[2].toString() + "'";
				BotId=BotId.replace("\"", "");
				//System.out.print(BotId + "BotId");
				
				EntityManager entityManager = entityManagerFactory.createEntityManager();
			      StoredProcedureQuery procedureQuery =
			              entityManager.createNamedStoredProcedureQuery(RealTimeModel.NamedQuery_KhalidStoreProcedure);	
			      LocationId = LocationId.replace("{LocationId:", "");
			      DepartmentId = DepartmentId.replace("DepartmentId:", "");
			      BotId = BotId.replace("BotId:", "").replace("}", "");
			      
			      LocationId = LocationId.replace("'","");
			      DepartmentId = DepartmentId.replace("'","");
			      BotId = BotId.replace("'","");
			   
			      procedureQuery.setParameter("pLocationId", Integer.parseInt(LocationId));
			      procedureQuery.setParameter("pDepartmentId", Integer.parseInt(DepartmentId));
			      procedureQuery.setParameter("pBotId", Integer.parseInt(BotId));
			      procedureQuery.setParameter("pType","Search");
			      procedureQuery.setParameter("pSearch","PolicyRenewal");
			      
			      
			      procedureQuery.execute(); 
			      @SuppressWarnings("unchecked")
			      List<Object[]> resultList = procedureQuery.getResultList();
			      for (Object[] r : resultList) {
			    	  //System.out.print(r[1]);
			    	  //System.out.print(r[2]);
			    	  JSONObject obj1 = new JSONObject();
					  //obj1.put("total_Bot_count",r[0]);
					  obj1.put("ProcessId",r[0]);	
					  obj1.put("BotName",r[1]);
					  obj1.put("LocationName",r[2]);
					  obj1.put("DepartmentName",r[3]);
					  obj1.put("Process_Name",r[4]);
					  obj1.put("Status",r[5]);
					  obj1.put("Remarks",r[6]);
					  obj1.put("CreatedBy",r[7]);
					  
 
					  ja1.add(obj1); 
			      }
				
			      return ja1.toString();		
			//}
			}catch (Exception e) {
			// TODO: handle exception
			}
		return null;
	}
	
	//For Login(PostMethhod) 
	@PostMapping(path = "/PostGetLoginData", consumes = "application/json", produces = "application/json")
	public String PostDataLoginResponse(			
			@RequestBody String postData) throws Exception {
			List<String> data1 = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();			
			try {
				System.out.println(postData);
				
				String[] arrOfStr = postData.split(",");
				String UserName = ""+"'" + arrOfStr[0].toString() + "'";
				UserName=UserName.replace("\"", "");
				
				//System.out.print(LocationId + "Location");
				String Password = ""+"'" + arrOfStr[1].toString() + "'";
				Password=Password.replace("\"", "");
				//System.out.print(DepartmentId + "Department");
				
				EntityManager entityManager = entityManagerFactory.createEntityManager();
			      StoredProcedureQuery procedureQuery =
			              entityManager.createNamedStoredProcedureQuery(LoginModel.NamedQuery_LoginStoreProcedure);	
			      UserName = UserName.replace("{UserName:", "");
			      Password = Password.replace("Password:", "");
			      UserName = UserName.replace("'","");
			      Password = Password.replace("'","");
			      UserName = UserName.replace("{Username:", "");
			      Password = Password.replace("}", "");
			      System.out.println(UserName);
			      System.out.println(Password);
			      procedureQuery.setParameter("pusername",UserName);
			      procedureQuery.setParameter("ppassword",Password);
			      procedureQuery.execute(); 
			      @SuppressWarnings("unchecked")
			      List<Object[]> resultList = procedureQuery.getResultList();
			      //U code i will guide. Check the lenth or count of list with if.Daro mat main hona leanr it and code
			      if(resultList.size() > 0)
			      {
			    	  
			    	  //System.out.print("listcount > 0");
			    	  for (Object[] r : resultList) {				    	 
				    	  JSONObject obj1 = new JSONObject();					
						  obj1.put("NotFound","Found");
						  ja1.add(obj1); 
				      }
			      }
			      else
			      {
			    	  //System.out.print("listcount =0");
			    	  JSONObject obj1 = new JSONObject();
			    	  obj1.put("NotFound","Invalid Credential !!!");
			    	  ja1.add(obj1); 
			      }				
			      return ja1.toString();	
			     
			}catch (Exception e) {
			// TODO: handle exception
			}
		return null;
	}
	
	@RequestMapping(value = "/function-call", method = RequestMethod.GET)
    public String getExampleHTML(Model model) {
        return "Dashboard.html";
    }

	
}
