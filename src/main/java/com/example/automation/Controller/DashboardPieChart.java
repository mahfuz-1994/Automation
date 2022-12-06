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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.automation.DAO.AutomationDAO;
import com.example.automation.JDBC.ConnectionFact;
import com.example.automation.Service.LocationService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class DashboardPieChart {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	@Autowired
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFact.getInstance().getConnection();
		return conn;
		
	}
	
	@PostMapping(path = "/PostGetDashboard", consumes = "application/json", produces = "application/json")
	public String JenkinsJsonResponse1(			
			@RequestBody String postData) throws Exception {
			List<String> data1 = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();			
			try {			
				String[] arrOfStr = postData.split(",");
				String LocationId = ""+"'" + arrOfStr[0].toString() + "'";
				LocationId=LocationId.replace("\"", "");
				System.out.print(LocationId);
				String DepartmentId = ""+"'" + arrOfStr[1].toString() + "'";
				DepartmentId=DepartmentId.replace("\"", "");
				System.out.print(DepartmentId);
				String BotId = ""+"'" + arrOfStr[2].toString() + "'";
				BotId=BotId.replace("\"", "");
				System.out.print(BotId);
				
					JSONObject obj1 = new JSONObject();	
					obj1.put("ProcesedCount",60);	
					obj1.put("UnProcessedCount",40);	
					ja1.add(obj1);
					return ja1.toString();			
			//}
			}catch (Exception e) {
			// TODO: handle exception
			}
		return null;
	}
}
