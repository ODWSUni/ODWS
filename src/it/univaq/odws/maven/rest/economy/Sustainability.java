package it.univaq.odws.maven.rest.economy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sustainability")
public interface Sustainability {
	
	@GET
	@Path("/country/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getSustainabilityByCountry (@PathParam("country")String country);
	
	@GET
	@Path("/variable/{variable}")
	@Produces({MediaType.APPLICATION_JSON})
	String getSustainabilityByVariable (@PathParam("variable")String variable);
	
	@GET
	@Path("/type/{type}")
	@Produces({MediaType.APPLICATION_JSON})
	String getSustainabilityByType (@PathParam("type")String type);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getSustainabilityByYear (@PathParam("year")String year);
	
	@GET
	@Path("/value/{value}")
	@Produces({MediaType.APPLICATION_JSON})
	String getSustainabilityByValue (@PathParam("value")String value);
	
	
}
