package com.pmt.service;

import java.util.List;

import com.pmt.model.Project;

public interface ProjectService {
	
	public void addProject(Project project);
    public void updateProject(Project project);
    public List<Project> listProjects();
    public Project getProjectById(int id);
    public void removeProject(int id);
    public List<Project> getProjectsByName(String name);
    public List<Project> getProjectsById(int id);
	

}
