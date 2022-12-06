package com.example.automation.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.automation.DAO.AutomationDAO;
import com.example.automation.JDBC.ConnectionFact;
import com.example.automation.Model.DashboardModel;
import com.example.automation.Model.DashboardModelList;
import com.example.automation.Model.DepartmentModel;
import com.example.automation.Repository.DashboardRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.automation.Service.LocationService;
import com.example.automation.Repository.*;

@RestController
@RequestMapping(path = "/DashBoardController")
public class DashBoardControllerDao {

		Connection connection = null;
		PreparedStatement ptmt = null; 
		ResultSet resultSet = null;
		 
		@Autowired		
		private AutomationDAO priyankaDAO;
		private DashboardRepo locationRepository;
		private LocationService locationservice;
		@Autowired
		private iLocationRepos iLocationRepos;
		private Connection getConnection() throws SQLException {
			Connection conn;
			conn = ConnectionFact.getInstance().getConnection();
			return conn;
			
		}
		
		//location
		@RequestMapping(value="/AllLocation", method = RequestMethod.GET)
		public int fetchsAllLocation() {
			
		//	String k= locationservice.fetchAllLocation(null); 
			return iLocationRepos.fetchAllLocation();
		//	return locationservice.fetchAllLocation();
			//return "hi";  
	    }
		
		
		//LocationRepository 
		@RequestMapping(value="/Location", method = RequestMethod.GET)
		public ResponseEntity<List<DashboardModel>> getLocation(){
		//Iterable<DashboardModel> location= DashboardRepo.getLocation();
		//List<DashboardModel> target = new ArrayList<>();
		 return null;
         }
		
		@GetMapping(path = "/Index")
		public String IndexPageReturn(ModelMap model) {
//			try {
//				ModelAndView mav = new ModelAndView("index");
//				//return "index.html";
//				return mav;
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			return "index";
		}
		
		@GetMapping(path = "/DashBoardModelList1", produces = "application/json")
		public DashboardModelList getPriyankaModel() {
			try {
				return priyankaDAO.getAllDashBoardModel();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
	//All about Databse 
		@GetMapping(path = "/GetPriyankaLogin", produces = "application/json")
		public String getPriyanka() {
			List<String> data = new ArrayList<String>();
			JSONArray ja = new JSONArray();
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				String queryString = "SELECT * FROM tbl_Location";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("LocationId " + resultSet.getInt("LocationId")
							+ ",LocationName  " + resultSet.getString("LocationName") + ", CreatedDate "
							+ resultSet.getString("CreatedDate")+ ",CreatedBy" + resultSet.getString("CreatedBy")
							+ ",UpdatedDate" + resultSet.getString("UpdatedDate")+ ",UpdatedBy" + resultSet.getString("UpdatedBy")
							+ ", IsActive" + resultSet.getString("IsActive"));
					
					JSONObject obj = new JSONObject();
					obj.put("LocationId",resultSet.getInt("LocationId"));
					obj.put("LocationName",resultSet.getString("LocationName"));
					obj.put("CreatedDate",resultSet.getString("CreatedDate"));	
					obj.put("CreatedBy",resultSet.getString("CreatedBy"));	
					obj.put("UpdatedDate",resultSet.getString("UpdatedDate"));	
					obj.put("UpdatedBy",resultSet.getString("UpdatedBy"));	
					obj.put("IsActive",resultSet.getString("IsActive"));	

					ja.add(obj);
				}
				return ja.toString();
			} catch (Exception e) {
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
		//post methhod
		@PostMapping(path = "/addPriyankamodelResponse", consumes = "application/json", produces = "application/json")
		public String addPriyankamodelResponse(
				@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
				@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "AMERICA") String headerLocation,
				@RequestBody DashboardModel demodel) throws Exception {
			try {
				// Generate resource id
				Integer id = priyankaDAO.getAllDashBoardModel().getdashboardModelList().size() + 1;
				demodel.setId(id);

				// add resource
				return priyankaDAO.addPriyankaModelString(demodel).toString();
	            // Create resource location
				//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				//		.buildAndExpand(employee.getId()).toUri();

				// Send location in response
				//return ResponseEntity.created(location).build();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		@PostMapping(path = "/addPriyankaJsonResponse", consumes = "application/json", produces = "application/json")
		public String addPriyankaJsonResponse(
				@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
				@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
				@RequestBody DashboardModel demodel) throws Exception {
			try {
				// Generate resource id
				Integer id = priyankaDAO.getAllDashBoardModel().getdashboardModelList().size() + 1;
				demodel.setId(id);

				// add resource
				return priyankaDAO.addPriyankaModelJson(demodel).toString();

				// Create resource location
				//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				//		.buildAndExpand(employee.getId()).toUri();

				// Send location in response
				//return ResponseEntity.created(location).build();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;

		}
		///new method for pass and user
		
		@PostMapping(path = "/APIJsonResponse1", consumes = "application/json", produces = "application/json")
		public String APIJsonResponse1(
				@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
				@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
				@RequestBody String value1) throws Exception {
				List<String> data1 = new ArrayList<String>();
				JSONArray ja1 = new JSONArray();
				
				try {
				
				String[] arrOfStr = value1.split(",");
				String u = ""+"'" + arrOfStr[0].toString() + "'";
				u=u.replace("\"", "");
				//System.out.print(u);
				String p = ""+"'" + arrOfStr[1].toString() + "'";
				p=p.replace("\"", "");
				//System.out.print(p);
				String queryString1 = "SELECT * FROM tbl_login where UserName="+u+" and UserPassword="+p;
				//String queryString1 = "SELECT * FROM tbl_login where UserName='Reegal'";
				//System.out.print(queryString1);
				
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString1);
				//ptmt.setString(1, u);
				//ptmt.setString(2, p);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("id " + resultSet.getInt("id")
							+ ", UserName " + resultSet.getString("UserName") + ", UserPassword "
							+ resultSet.getString("UserPassword"));
					
					JSONObject obj1 = new JSONObject();				
					obj1.put("id",resultSet.getInt("id"));
					obj1.put("UserName",resultSet.getString("UserName"));
					obj1.put("UserPassword",resultSet.getString("UserPassword"));										
					ja1.add(obj1);
				}
				
					return ja1.toString();			
				} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		}
			
		@PostMapping(path = "/JenkinsAPI", consumes = "application/json", produces = "application/json")
		public String JenkinsJsonResponse1(			
				@RequestBody String value1) throws Exception {
				List<String> data1 = new ArrayList<String>();
				JSONArray ja1 = new JSONArray();			
				try {
				
				String[] arrOfStr = value1.split(",");
				String u = ""+"'" + arrOfStr[0].toString() + "'";
				u=u.replace("\"", "");
				//System.out.print(u);
				String p = ""+"'" + arrOfStr[1].toString() + "'";
				p=p.replace("\"", "");
				//System.out.print(p);
				String queryString1 = "SELECT * FROM tbl_login where UserName="+u+" and UserPassword="+p;
				//String queryString1 = "SELECT * FROM tbl_login where UserName='Reegal'";
				//System.out.print(queryString1);
				
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString1);
				//ptmt.setString(1, u);
				//ptmt.setString(2, p);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("id " + resultSet.getInt("id")
							+ ", UserName " + resultSet.getString("UserName") + ", UserPassword "
							+ resultSet.getString("UserPassword"));
					
					JSONObject obj1 = new JSONObject();				
					obj1.put("id",resultSet.getInt("id"));
					obj1.put("UserName",resultSet.getString("UserName"));
					obj1.put("UserPassword",resultSet.getString("UserPassword"));										
					ja1.add(obj1);
				}
					return ja1.toString();			
				} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}	
	}
