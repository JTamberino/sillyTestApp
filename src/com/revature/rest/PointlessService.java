package com.revature.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.pojo.TestObject;

@Path("/pointless")
public class PointlessService {

	@GET
	@Path("/things/{param}")
	public Response Pointless(@PathParam("param") String words){
		
		String output = words + " from pointless.";
		return Response.status(200).entity(output).build();
		
	}
	
	@GET
	@Path("/testObject")
	@Produces(MediaType.APPLICATION_JSON)
	public TestObject testObj(){
		TestObject newObj = new TestObject();
		newObj.setName("Bob");
		newObj.setAge(34);
		
		return newObj;
		
	}
	
}
