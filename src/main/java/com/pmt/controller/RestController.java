package com.pmt.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


@Component
@Path("/transaction")
public class RestController {
	
	

	@GET
	@Path("/payment")
	public Response savePayment() {

		String result = "This is a sample text";
		

		return Response.status(200).entity(result).build();

	}


}
