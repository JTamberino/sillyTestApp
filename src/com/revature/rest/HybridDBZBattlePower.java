package com.revature.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bp")
public class HybridDBZBattlePower {

	@Path("/kaioken")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public int kaioken(@QueryParam("base") int base, @DefaultValue("2") @QueryParam("multi")int multi) {
		// TODO Auto-generated method stub
		return base*multi;
	}

	@Path("/ssj")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int ssj(@QueryParam("base") int base, @DefaultValue("false") @QueryParam("fpssj") boolean fpssj) {
		if (fpssj){
			if (base > 7_000_000){
				return 343_000_000 + base;
			}
			return base * 50;
		}
		if (base > 3_600_000 ){
			return 176_400_000 +base;
		}
		return base * 50;
	}

	@Path("/ssjg2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int ssjg2(@QueryParam("base") int base) {
		if (base > 4500000) {
			return 220500000 + base;
		}
		return base * 50;
	}

	@Path("/ssjg3")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int ssjg3(@QueryParam("base") int base) {
		if (base > 5500000) {
			return 269500000 + base;
		}
		return base * 50;
	}

	@Path("/ssj2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int ssj2(@QueryParam("base") int base, @DefaultValue("false") @QueryParam("fpssj")boolean fpssj) {
		int newPower = ssj(base, fpssj)-base;
		newPower = newPower * 2;
		newPower += base;
		return newPower;
	}

	@Path("/ssj3")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int ssj3(@QueryParam("base") int base, @DefaultValue("false") @QueryParam("fpssj") boolean fpssj) {
		int newPower = ssj(base,fpssj)-base;
		newPower = newPower * 8;
		newPower += base;
		return newPower;
	}
	
	@Path("/mmfusion")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public int mmfusion(@QueryParam("base1") int base1, @QueryParam("base2") int base2,
			@DefaultValue("false") @QueryParam("ssja") boolean ssja,
			@DefaultValue("false") @QueryParam("ssjb") boolean ssjb){
			int powera = base1;
			int powerb = base2;
			if (ssja){
				powera = ssj(base1, false);
			}
			if (ssjb){
				powerb = ssj(base2, false);
			}
			return powera + powerb;
	}

}
