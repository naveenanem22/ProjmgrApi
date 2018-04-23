package com.pmt.dao;

import java.util.List;

import com.pmt.model.Project;
import com.pmt.model.Skill;

public interface ProjectDao {
	
	public void addProject(Project project);
    public void updateProject(Project client);
    public List<Project> listProjects();
    public Project getProjectById(int id);
    public void removeProject(int id);
    public List<Project> getProjectsByName(String name);
    public List<Project> getProjectsById(int id);
	

}
