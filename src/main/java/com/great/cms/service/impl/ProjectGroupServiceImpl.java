package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.db.dao.GroupsDao;
import com.great.cms.db.dao.ProjectDao;
import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.dao.TaskDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.service.ProjectGroupService;

public class ProjectGroupServiceImpl implements ProjectGroupService,Serializable{

	@Autowired
	private ProjectGroupDao projectGroupDao;
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private GroupsDao groupsDao;
	@Autowired
	private StudentGroupDao studentGroupDao;
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Groups> findGroupsByProjectId(int projectId) {
		List<ProjectGroup> projectGroupList = projectGroupDao.findAll();
		List<Groups> groupList = new ArrayList();
		for(ProjectGroup pg : projectGroupList)
		{
			groupList.add(pg.getGroupId());
		}
		return groupList;
	}

	@Override
	public void addGroupOfProject(int projectId, String groupName,
			List<Student> studentList,int taskId) {
		Groups group;
		group = new Groups();
		group.setGroupName(groupName);
		group.setTaskId(taskDao.findById(taskId));
		groupsDao.save(group);
		for(Student s: studentList)
		{
			StudentGroup studentGroup =new StudentGroup();
			studentGroup.setGroupId(group);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);
			
			
		}
		ProjectGroup projGrp = new ProjectGroup();
		projGrp.setGroupId(group);
		projGrp.setProjectId(projectDao.findById(projectId));
		
		projectGroupDao.save(projGrp);
		
	}

	@Override
	public void editGroupofProject(int groupId, List<Student> studentList) {
		
		Groups group = groupsDao.findById(groupId);
		
		List<StudentGroup> studgroupList= studentGroupDao.findStudentByGroupId(groupId);
		
		for(StudentGroup sg:studgroupList )
		{
			studentGroupDao.delete(sg);
		}
		for(Student s: studentList)
		{
			StudentGroup studentGroup =new StudentGroup();
			studentGroup.setGroupId(group);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);
			
			
		}
		
	}

	@Override
	public void deleteGroupOfProject(int groupId) {
		groupsDao.deleteById(groupId);
		
	}



	

}
