package com.example.automation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {
	
	@Autowired
	//private DashboardService dash;
	
	@GetMapping("/Dashboard")
	public ModelAndView invokeme() {
		ModelAndView mav = new ModelAndView("Dashboard");
		return mav;
	}
	
	@GetMapping("/dataGridT")
    public ModelAndView invokedatagrid() {
	ModelAndView mav = new ModelAndView("datatableT");
	return mav;
}
	
	
    @GetMapping("/BotMaster")
    public ModelAndView invoke() {
	ModelAndView mav = new ModelAndView("BotMaster");
	//mav.addObject("std", new Details());
	return mav;
}

    @GetMapping("/DepartmentMaster")
     public ModelAndView invoke1() {
	ModelAndView mav = new ModelAndView("DepartmentMaster");
	//mav.addObject("std", new Details());
	return mav;
}


   @GetMapping("/LocationMaster")
     public ModelAndView invoke2() {
	ModelAndView mav = new ModelAndView("LocationMaster");
	//mav.addObject("std", new Details());
	return mav;
}
   

	@GetMapping("/LocationList")
	public ModelAndView invokeme3() {
		ModelAndView mav = new ModelAndView("LocationList");
		//mav.addObject("std", new DashboardDomain().Returnlist());
		return mav;
	}
}
