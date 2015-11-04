package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.CourseRegistration;
import com.great.cms.repository.CourseRepository;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.CourseService;
import com.great.cms.service.TeacherCourseService;

@Controller
public class CourseController {

	@Autowired
	private TeacherCourseService courseService;
	
	@Autowired
	private CourseRegistrationService courseRegistrationService;
	
	private JSONArray jsonArray;

	@RequestMapping(method = RequestMethod.GET, value = "/course")
	public  String getCourse(Model model) {
		System.out.println("Course Controller");
		/*String courses = courseService.getCourseListByUserId(userId);//courseRepository.findAll();		
	*/
	    List<Course> courses = courseService.getCourseListByUsername("sknabil");
		model.addAttribute("courses", courses);
		
		
		/*jsonArray = new JSONArray();
		if(courses==null)
			System.out.println("list is null");
	    for(Course t: courses)
	    {
	    	JSONArray jObj = new JSONArray();
	    	jObj.add(t.getCourseId().toString());
	    	jObj.add(t.getCourseTitle());
	    	jObj.add(t.getCourseCode());
	    	jObj.add(String.valueOf(t.getCredit()));
	    	jObj.add(String.valueOf(t.getSemester()));
	    	jObj.add(String.valueOf(t.getSession()));
	    	jObj.add(t.getAcceptingDept());
	    	jObj.add(t.getOfferingDept());
	    	
	    	
	    	jsonArray.add(jObj);  	
	    	

	    }
	    JSONObject parameters = new JSONObject();

    	parameters.put("draw", 1);

    	parameters.put("recordsTotal", 1 );
    	
    	parameters.put("recordsFiltered", 1 );
    	
    	parameters.put("data", jsonArray);
    	
    	String courseJson = parameters.toJSONString();
    	
		return courseJson;*/
		return "course";
		
		
		
	}

}
