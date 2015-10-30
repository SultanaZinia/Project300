package com.great.cms.service;

import java.util.List;


import com.great.cms.db.entity.Groups;

public interface ProjectGroupService {
	
	public List<Groups> findGroupsByProjectId(int projectId);
	public void addGroupToProject(int projectId, Groups group);
	public void updateProjectGroup(int projectGroupID, Groups group);

}
