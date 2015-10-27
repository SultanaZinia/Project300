package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Task;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.db.entity.User;
import com.great.cms.service.TeacherCourseService;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


//Tested
@Repository
@Service("TeacherCourseService")
public class TeacherCourseServiceImpl implements TeacherCourseService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeachesDao teachesDao;
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private UserDao userDao;

	List<Course> list = new ArrayList<>();
	List<Teaches> teaches = new ArrayList<>();
	List<Teacher> teacher = new ArrayList<>();
	Long InstructorId = null;
	private JSONArray jsonArray;

	@Override
	public List<Course> getCourseListByUserId(Long userId) {

		teacher = teacherDao.findByUserId(userId);
		for (Teacher teachers : teacher) {

			InstructorId = teachers.getInstructorId();
		}
		teaches = teachesDao.findByInstructorId(InstructorId);

		if (teaches != null && teaches.size() > 0) {
			for (Teaches teach : teaches) {

				Course course = teach.getCourseId();

				System.out.println("##" + course.getCourseTitle());

				list.add(course);

			}
		}
		
    	
		return list;

	}

	@Override
	public List<Course> getCourseListByInstructionId(Long InstId) {
		List<Teaches> teach = new ArrayList<>();

		List<Course> course = new ArrayList<>();

		teach = teachesDao.findByInstructorId(InstId);
		for (Teaches teaches : teach) {
			System.out.println(teaches.getCourseId().getCourseCode());
			course.add(teaches.getCourseId());

		}
		
    	
		return course;

	}

	@Override
	public List<Course> getCourseListByUsername(String UserName) {
		System.out.println("TeacherCourseService");
		User user = userDao.findUserByName(UserName);
		
		list=getCourseListByUserId(user.getUserId());
		return list;
	}

}
