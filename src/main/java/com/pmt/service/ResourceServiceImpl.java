package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.ResourceDao;
import com.pmt.model.Resource;


@Service(value="resourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	@Qualifier("resourceDaoImpl")
	private ResourceDao resourceDao;

	@Override
	@Transactional
	public void addResource(Resource resource) {
		resourceDao.addResource(resource);
		
	}

	@Override
	@Transactional
	public void updateResource(Resource resource) {
		
		resourceDao.updateResource(resource);
	}

	@Override
	@Transactional
	public List<Resource> listResources() {
		
		return resourceDao.listResources();
	}

	@Override
	@Transactional
	public Resource getResourceById(int id) {
		
		return resourceDao.getResourceById(id);
	}

	@Override
	@Transactional
	public void removeResource(int id) {
		
		resourceDao.removeResource(id);
	}

	@Override
	@Transactional
	public List<Resource> getResourcesByName(String name) {
		
		return resourceDao.getResourcesByName(name);
	}

	@Override
	@Transactional
	public List<Resource> getResourcesById(int id) {
		
		return resourceDao.getResourcesById(id);
	}

	@Override
	@Transactional
	public int updateResourceSkill(int resourceId,int skillId, int selfRating, boolean coreSkill) {
		return resourceDao.updateResourceSkill(resourceId, skillId, selfRating, coreSkill);
		
	}

	@Override
	@Transactional
	public List<Integer> getResourceSkillIds(int resourceId) {
		
		return resourceDao.getResourceSkillIds(resourceId);
	}

		
	

}
