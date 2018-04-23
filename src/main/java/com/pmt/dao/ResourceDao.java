package com.pmt.dao;

import java.util.List;

import com.pmt.model.Resource;
import com.pmt.model.Skill;

public interface ResourceDao {
	
	public void addResource(Resource resource);
    public void updateResource(Resource resource);
    public List<Resource> listResources();
    public Resource getResourceById(int id);
    public void removeResource(int id);
    public List<Resource> getResourcesByName(String name);
    public List<Resource> getResourcesById(int id);
    public int updateResourceSkill(int resourceId, int skillId,int selfRating, boolean coreSkill);
	public List<Integer> getResourceSkillIds(int resourceId);

}
