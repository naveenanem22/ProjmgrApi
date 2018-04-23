package com.pmt.dao;

import java.util.List;

import com.pmt.model.Region;
import com.pmt.model.Skill;

public interface RegionDao {
	
	public void addRegion(Region region);
    public void updateRegion(Region region);
    public List<Region> listRegions();
    public Region getRegionById(int id);
    public void removeRegion(int id);
    public List<Region> getRegionsById(int id);
    public List<Region> getRegionsByName(String name);
	

}
