package com.crudSimple.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudSimple.Dao.curdMytableQuery;
import com.crudSimple.Model.crudMytableJPA;
import com.crudSimple.Service.Mytable.crudService;
import com.crudSimple.Model.crudSpringMytable;

@Controller
public class CrudController {
	@Autowired
	crudSpringMytable crudSpringMytable;

	@Autowired
	crudService crudService;

	@Autowired
	curdMytableQuery curdMytableQuery;

	@GetMapping("/index")
	public String index(@ModelAttribute crudMytableJPA myTableJPA) {
		return "index";
	}

	@RequestMapping("/createAction")
	public String createAction(@ModelAttribute crudSpringMytable addData) {
		crudService.addMember(addData);
		return "welcome";
	}

	@GetMapping("/queryPage")
	public String queryPage() {
		return "queryPage";
	}

	@PostMapping("/queryAction")
	public String queryAction(@ModelAttribute crudMytableJPA queryData, Model model) {
		List<crudMytableJPA> queryMytable = new ArrayList<crudMytableJPA>();
		queryMytable = curdMytableQuery.findMytable(queryData.getUsername(), queryData.getPasswd());

		model.addAttribute("dataForm", queryMytable);
		return "queryAction";
	}

	@GetMapping("/updatePage")
	public String updatePage(@ModelAttribute crudMytableJPA queryData, Model model) {
		List<crudMytableJPA> updatePageList = new ArrayList<crudMytableJPA>();
		updatePageList = curdMytableQuery.findMytableByUpdate(queryData.getId());

		model.addAttribute("dataForm", updatePageList);
		return "updatePage";
	}
	
	@PostMapping("/updateAction")
	public String updateAction(@ModelAttribute crudMytableJPA queryData, Model model) {
		curdMytableQuery.updatwMytableById(queryData.getUsername(), queryData.getId());
		
		return "updateAction";
	}
	
	@GetMapping("/insertPage")
	public String insertPage(Model model) {
		return "insertPage";
	}
	
	@PostMapping("/insertAction")
	public String insertAction(@ModelAttribute crudMytableJPA queryData, Model model) {
		curdMytableQuery.insertMytable(queryData.getUsername(), queryData.getPasswd());
		
		return "insertAction";
	}
	
	@GetMapping("/deleteAction")
	public String deleteAction(@ModelAttribute crudMytableJPA queryData, Model model) {
		curdMytableQuery.deleteMytableById(queryData.getId());
		
		return "deleteAction";
	}
}
