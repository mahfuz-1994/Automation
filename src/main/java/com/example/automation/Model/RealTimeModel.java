package com.example.automation.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;



@NamedStoredProcedureQuery(
	      name = "Usp_Tbl_RealTimeData",
	      procedureName = "get_Tbl_RealTimeData",
	    		  parameters = {
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pLocationId", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pBotId", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pDepartmentId", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ProcessedCount", type = Integer.class),
	    	              @StoredProcedureParameter(mode = ParameterMode.OUT, name = "UnProcessedCount", type = Integer.class)})
	      



@NamedStoredProcedureQuery(
	      name = RealTimeModel.NamedQuery_KhalidStoreProcedure,
	      procedureName = "get_Tbl_RealTimeBind",
	      parameters = {
	    		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "pLocationId", type = Integer.class),
	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pBotId", type = Integer.class),
	              @StoredProcedureParameter(mode = ParameterMode.IN, name = "pDepartmentId", type = Integer.class),
	        
	              
	      }
	)

@Entity
@Table(name="Tbl_RealTimeData")


public class RealTimeModel {
	 public static final String NamedQuery_KhalidStoreProcedure = "KhalidStoreProcedure";
	  public static final String NamedQuery_FetchFromRealTimeData = "FetchFromRealTimeData";
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) 
	
	private int ProcessId;
	private int BotId ;
	private int LocationId;
    private int DepartmentId;
    private String Process_Name;
    private String Host_Name;
    private int Transaction_ID;
    private Date StartTime;
    private Date EndTime;
    private String Status;
    private String Remarks;
    private Date CreatedDate;
    private String CreatedBy;
    private Date UpdatedDate;
    private String UpdatedBy;
    private boolean IsActive;
	public int getProcessId() {
		return ProcessId;
	}
	public void setProcessId(int processId) {
		ProcessId = processId;
	}
	public int getBotId() {
		return BotId;
	}
	public void setBotId(int botId) {
		BotId = botId;
	}
	public int getLocationId() {
		return LocationId;
	}
	public void setLocationId(int locationId) {
		LocationId = locationId;
	}
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public String getProcess_Name() {
		return Process_Name;
	}
	public void setProcess_Name(String process_Name) {
		Process_Name = process_Name;
	}
	public String getHost_Name() {
		return Host_Name;
	}
	public void setHost_Name(String host_Name) {
		Host_Name = host_Name;
	}
	public int getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public Date getUpdatedDate() {
		return UpdatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return UpdatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	@Override
	public String toString() {
		return "RealTimeModel [ProcessId=" + ProcessId + ", BotId=" + BotId + ", LocationId=" + LocationId
				+ ", DepartmentId=" + DepartmentId + ", Process_Name=" + Process_Name + ", Host_Name=" + Host_Name
				+ ", Transaction_ID=" + Transaction_ID + ", StartTime=" + StartTime + ", EndTime=" + EndTime
				+ ", Status=" + Status + ", Remarks=" + Remarks + ", CreatedDate=" + CreatedDate + ", CreatedBy="
				+ CreatedBy + ", UpdatedDate=" + UpdatedDate + ", UpdatedBy=" + UpdatedBy + ", IsActive=" + IsActive
				+ "]";
	}
    
	
    
    
    
    
}
