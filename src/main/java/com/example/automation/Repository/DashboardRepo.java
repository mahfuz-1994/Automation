package com.example.automation.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.automation.Model.DashboardModel;

@Repository
public interface DashboardRepo{
	List<DashboardModel> getLocation();
	//List <DepartmentModel> getDepartment();
}


