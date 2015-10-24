package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.db.entity.Project;
import com.great.cms.db.entity.Submission;
import com.great.cms.service.TaskProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private TaskProjectService taskProjectService; 
	private JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET,value="/ajaxprojects")
	public @ResponseBody String getProjectList(Model model)
	{
		System.out.println("Project Controller -> getProjectList");
		List<Project> projectList = null;
		
		projectList =  taskProjectService.findProjectsByTaskID(1);
		
		System.out.println("Project Controller -> getProjectList " + projectList);
		
		//model.addAttribute("submissions",submissionList);
		
		jsonArray = new JSONArray();
		
		if(projectList==null)
		 System.out.println("Project Controller -> getProjectList : LIST IS NULL");
		if(projectList.size() == 0)
			 System.out.println("Project Controller -> getProjectList : LIST IS EMPTY");
	
	    
	    for(Project proj: projectList)
	    {
	    	JSONArray jsonObj = new JSONArray();
	    	jsonObj.add(proj.getProjectId().toString());
	    	jsonObj.add(proj.getProjectTitle());
	    	jsonObj.add(proj.getProjectDesc());

	    	//proj.ge
	    	
	    	/*if( s.getTaskTypeId().getTaskTypeId()==1)
	    	jsonObj.add("Project");
	    	else
		    jsonObj.add("Assignment");*/
	    	
	    	System.out.println("proj id : " + proj.getProjectId());
	    	
	    	jsonArray.add(jsonObj);  
	}
	    
	    JSONObject parameters = new JSONObject();

    	parameters.put("draw", 1);

    	parameters.put("recordsTotal", 1 );
    	
    	parameters.put("recordsFiltered", 1 );
    	
    	parameters.put("data", jsonArray);
    	
    	String submissionJson = parameters.toJSONString();
    	
    	//System.out.print("DLSJDHSLKJDH:  "+taskJson);
		return submissionJson;
	
}
	@RequestMapping(value="/addproject",method=RequestMethod.POST)
    public @ResponseBody String addSubmission(Project project,int taskId)
    {
		System.out.println("Project Controller -> addproject");
		taskProjectService.addProjectOfTask(project, 1);
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value="/updateproject",method=RequestMethod.POST)
    public @ResponseBody String updateProject(Project project,int taskId)
    {
		System.out.println("Project Controller -> updateProject");
		taskProjectService.updateProjectOfTask(project, taskId);
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value = "/deleteproject", method = RequestMethod.POST)
	public @ResponseBody String deletetask(@RequestParam("projectId") int projectId) {

		taskProjectService.deleteProjectOfTask(projectId);
		return "{ \"success\" : true }";
	}
}
