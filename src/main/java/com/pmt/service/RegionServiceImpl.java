package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.RegionDao;
import com.pmt.model.Region;


@Service(value="regionServiceImpl")
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	@Qualifier("regionDaoImpl")
	private RegionDao regionDao;

	@Override
	@Transactional
	public void addRegion(Region region) {
		regionDao.addRegion(region);
		
	}

	@Override
	@Transactional
	public void updateRegion(Region region) {
		
		regionDao.updateRegion(region);
	}

	@Override
	@Transactional
	public List<Region> listRegions() {
		
		return regionDao.listRegions();
	}

	@Override
	@Transactional
	public Region getRegionById(int id) {
		
		return regionDao.getRegionById(id);
	}

	@Override
	@Transactional
	public void removeRegion(int id) {
		
		regionDao.removeRegion(id);
	}

	@Override
	@Transactional
	public List<Region> getRegionsByName(String name) {
		
		return regionDao.getRegionsByName(name);
	}

	@Override
	@Transactional
	public List<Region> getRegionsById(int id) {
		
		return regionDao.getRegionsById(id);
	}

		
	

}
