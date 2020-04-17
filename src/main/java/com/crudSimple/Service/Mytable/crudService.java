package com.crudSimple.Service.Mytable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.crudSimple.Model.crudMytableJPA;
import com.crudSimple.Model.crudSpringMytable;
import com.crudSimple.Dao.crudMytableCreate;
import com.crudSimple.Dao.curdMytableQuery;

@Service
public class crudService {
	@Autowired
	crudMytableCreate crudMytableCreate;
	
	@Autowired
	crudSpringMytable crudSpringMytable;
	
	public void addMember(crudSpringMytable addData) {
		crudSpringMytable = new crudSpringMytable();

		crudSpringMytable.setUsername(addData.getUsername());
		crudSpringMytable.setPasswd(addData.getUsername());

		crudMytableCreate.addMytable(crudSpringMytable);
	}
}