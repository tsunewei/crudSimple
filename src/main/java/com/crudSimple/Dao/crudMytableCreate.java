package com.crudSimple.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crudSimple.Model.crudSpringMytable;

@Repository
public class crudMytableCreate {
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public void addMytable(crudMytableDao addData) {
//		jdbcTemplate.update("INSERT INTO MYTABLE(USERNAME, PASSWORD,systime) VALUES (?,?,?,NOW())",
//				addData.getUsername(), addData.getPasswd());
//	}
	
	public void addMytable(crudSpringMytable addData) {
		jdbcTemplate.update("INSERT INTO MYTABLE(USERNAME, PASSWD,systime) VALUES (?,?,NOW())",
				addData.getUsername(), addData.getPasswd());
	}
}
