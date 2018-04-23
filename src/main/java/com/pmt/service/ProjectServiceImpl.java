package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.ProjectDao;
import com.pmt.model.Project;


@Service(value="projectServiceImpl")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	@Qualifier("projectDaoImpl")
	private ProjectDao projectDao;

	@Override
	@Transactional
	public void addProject(Project project) {
		projectDao.addProject(project);
		
	}

	@Override
	@Transactional
	public void updateProject(Project project) {
		
		projectDao.updateProject(project);
	}

	@Override
	@Transactional
	public List<Project> listProjects() {
		
		return projectDao.listProjects();
	}

	@Override
	@Transactional
	public Project getProjectById(int id) {
		
		return projectDao.getProjectById(id);
	}

	@Override
	@Transactional
	public void removeProject(int id) {
		
		projectDao.removeProject(id);
	}

	@Override
	@Transactional
	public List<Project> getProjectsByName(String name) {
		
		return projectDao.getProjectsByName(name);
	}

	@Override
	@Transactional
	public List<Project> getProjectsById(int id) {
		
		return projectDao.getProjectsById(id);
	}

		
	

}
