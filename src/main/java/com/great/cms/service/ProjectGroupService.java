package com.great.cms.service;

import java.util.List;




import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.Task;

public interface ProjectGroupService {
	
	public List<Groups> findGroupsByProjectId(int projectId);
	public void addGroupOfProject(int projectId, String groupName, List<Student>studentList,int taskId);
	public void editGroupofProject(int groupId, List<Student> studentList);
	public void deleteGroupOfProject(int groupId);

}
