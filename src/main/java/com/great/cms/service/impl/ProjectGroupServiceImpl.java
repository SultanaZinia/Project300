package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.service.ProjectGroupService;

public class ProjectGroupServiceImpl implements ProjectGroupService,Serializable{

	@Autowired
	private ProjectGroupDao projectGroupDao;
	
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
	public void addGroupToProject(int projectId, Groups group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProjectGroup(int projectGroupID, Groups group) {
		// TODO Auto-generated method stub
		
	}

}
