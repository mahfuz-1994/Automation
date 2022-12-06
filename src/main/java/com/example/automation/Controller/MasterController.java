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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.automation.JDBC.ConnectionFact;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MasterController {	
	
		Connection connection = null;
		PreparedStatement ptmt = null;
		ResultSet resultSet = null;
		
		@Autowired
		private Connection getConnection() throws SQLException {
			Connection conn;
			conn = ConnectionFact.getInstance().getConnection();
			return conn;
			
		}
		
		@GetMapping(path = "/GetLocation", produces = "application/json")
		public String getPriyanka() {
			List<String> data = new ArrayList<String>();
			JSONArray ja1 = new JSONArray();
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				String queryString = "SELECT LocationId,LocationName FROM tbl_location";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {		
					JSONObject obj1 = new JSONObject();
					obj1.put("LocationId",resultSet.getInt("LocationId"));
					obj1.put("LocationName",resultSet.getString("LocationName"));
					
					ja1.add(obj1);
				}
				return ja1.toString();
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
		
		@GetMapping(path = "/GetDepartment", produces = "application/json")
		public String getData() {
			List<String> data = new ArrayList<String>();
			JSONArray ja = new JSONArray();
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				String queryString = "SELECT DepartmentId,DepartmentName FROM Tbl_Department";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {		
					JSONObject obj = new JSONObject();
					obj.put("DepartmentId",resultSet.getInt("DepartmentId"));
					obj.put("DepartmentName",resultSet.getString("DepartmentName"));
					
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
		
		@GetMapping(path = "/GetBotName", produces = "application/json")
		public String getBotData() {
			List<String> data = new ArrayList<String>();
			JSONArray ja = new JSONArray();
			ObjectMapper mapper = new ObjectMapper();
			try {
				
				String queryString = "SELECT BotId,BotName FROM Tbl_BotName";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet = ptmt.executeQuery();
				while (resultSet.next()) {		
					JSONObject obj = new JSONObject();
					obj.put("BotId",resultSet.getInt("BotId"));
					obj.put("BotName",resultSet.getString("BotName"));
					
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
		

		
	}
		


