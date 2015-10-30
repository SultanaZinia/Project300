package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.Task;
import com.great.cms.service.ProjectGroupService;
import com.great.cms.service.TaskGroupService;

public class ProjectGroupController {
	
	@Autowired
	private ProjectGroupService projectGroupService;
	private JSONArray jsonArray;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET,value="/ajaxgroups")
	public @ResponseBody String getGroupListbyProjectId(Model model,@RequestParam("project_id") int projectId)
	{
		
		
		System.out.println("ProjectGroupController  -> getGroupListbyProjectId");
		
		List<Groups> groupList = null;
		
		groupList = projectGroupService.findGroupsByProjectId(2); 
		
		System.out.println("ProjectGroupController  -> groupList " + groupList);
		
		//model.addAttribute("submissions",submissionList);
		
		jsonArray = new JSONArray();
		
		if(groupList==null)
		 System.out.println(" ProjectGroupController  -> getGroupListbyProjectId : LIST IS NULL");
		if(groupList.size() == 0)
			 System.out.println("ProjectGroupController  -> getGroupListbyProjectId : LIST IS EMPTY");
	
	    
	    for(Groups grp: groupList)
	    {
	    	JSONArray jsonObj = new JSONArray();
	    	jsonObj.add(grp.getGroupId().toString());
	    	jsonObj.add(grp.getGroupName());
	    	jsonObj.add(grp.getProjectGroupList().toString());
	    	jsonObj.add(grp.getStudentGroupList().toString());
	    		    	
	    	jsonArray.add(jsonObj);  
	}
	    
	    JSONObject parameters = new JSONObject();

    	parameters.put("draw", 1);

    	parameters.put("recordsTotal", 1 );
    	
    	parameters.put("recordsFiltered", 1 );
    	
    	parameters.put("data", jsonArray);
    	
    	String groupJson = parameters.toJSONString();
    	
    	//System.out.print("DLSJDHSLKJDH:  "+taskJson);
		return groupJson;
	
}
	@RequestMapping(value="/addgroup",method=RequestMethod.POST)
    public @ResponseBody String addGroup(int projectId ,String groupName,List<Student> studentList,int taskId )
    {
		System.out.println("ProjectGroupController  -> addgroup");
		
		projectGroupService.addGroupOfProject(projectId, groupName, studentList, taskId);
		
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value="/editgroup",method=RequestMethod.POST)
    public @ResponseBody String editGroup(int groupId ,List<Student> studentList )
    {
		System.out.println("ProjectGroupController  -> editgroup");
		
		projectGroupService.editGroupofProject(groupId, studentList);
		
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value="/deletegroup",method=RequestMethod.POST)
    public @ResponseBody String deleteGroup(int groupId  )
    {
		System.out.println("ProjectGroupController  -> deletegroup");
		
		projectGroupService.deleteGroupOfProject(groupId);
		
		return "{ \"success\" : true }";
    }
	
}
