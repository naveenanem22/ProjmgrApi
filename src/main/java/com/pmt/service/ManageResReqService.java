package com.pmt.service;

import java.util.List;
import java.util.Map;

public interface ManageResReqService {
	
	public void populateResReq(Map<String,String> resReqForm);
	public List listResReq();
	public void populateResAll();
	public void processNewResReq(Integer[] reqDetIds);

}
