package com.dacartec.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dacartec.dto.CarpetaRequestDTO;
import com.dacartec.service.impl.AutorizacionLogica;
import com.dacartec.service.impl.SharepointLogica;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Path("/api") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class SharepointService {
	private static final Log log = LogFactory.getLog(SharepointService.class);
	
	private ISharepointService sharepointService;
	
	@POST
	@Path("/cargarArchivo")
	public String cargarArchivo(String nombreArchivo) {
		sharepointService = new SharepointLogica();

		log.info("Se ejecuta el servicio");
		
		return sharepointService.cargarArchivo(nombreArchivo);
	}
	
	@POST
	@Path("/crearCarpeta")
	public String crearCarpeta(CarpetaRequestDTO carpetaRequestDTO) {
		sharepointService = new SharepointLogica();

		log.info("Se ejecuta el servicio");
		
		return sharepointService.crearCarpeta(carpetaRequestDTO.getNombreCarpeta(), carpetaRequestDTO.getRuta());
	}
	
	@POST
	@Path("/token")
	public String generarToken() {
		
		AutorizacionLogica autorizacionLogica = new AutorizacionLogica();
		String token = autorizacionLogica.generarToken();
		
		log.info("Se ejecuta el servicio");
		
		return token;
	}
	
	@POST
	@Path("/permisos")
	public String asignarPermisos() {
		
		sharepointService = new SharepointLogica();

		log.info("Se ejecuta el servicio");
		
		return sharepointService.asignarPermisos();
	}
}
