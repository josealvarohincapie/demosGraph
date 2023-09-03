package com.dacartec.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dacartec.service.impl.PlanLogica;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/api") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class PlanService {
	private static final Log log = LogFactory.getLog(PlanService.class);
	
	private IPlanService planService;
	
	@GET
	@Path("/plan")
	public String consultarPlanPorId(String idPlan) {
		planService = new PlanLogica();

		log.info("Se ejecuta el servicio");
		
		return planService.consultarPlanPorId(idPlan);
	}
}
