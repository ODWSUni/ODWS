package it.univaq.odws.maven.rest.economy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agriculture")
public interface Agriculture {
	
	@GET
	@Path("/country/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAgricultureByCountry (@PathParam("country")String country);
	
	@GET
	@Path("/variable/{variable}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAgricultureByVariable (@PathParam("variable")String variable);
	
	@GET
	@Path("/type/{type}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAgricultureByType (@PathParam("type")String type);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAgricultureByYear (@PathParam("year")String year);
	
	@GET
	@Path("/value/{value}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAgricultureByValue (@PathParam("value")String value);
	
	
}
