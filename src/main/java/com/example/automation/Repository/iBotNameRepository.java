package com.example.automation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.automation.Model.BotModel;


public interface iBotNameRepository extends JpaRepository<BotModel,Long>{	
	@Procedure("get_Tbl_BotName")
	public String fetchBotName();
}
