package com.pmt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SuppressWarnings("serial")
public class HibernateAwareObjectMapper extends ObjectMapper {
	
	public HibernateAwareObjectMapper(){
		Hibernate4Module hm = new Hibernate4Module();
		hm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
		registerModule(hm);
	}

}
