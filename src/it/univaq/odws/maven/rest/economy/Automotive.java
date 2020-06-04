package it.univaq.odws.maven.rest.economy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/automotive")
public interface Automotive {
	
	@GET
	@Path("/country/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAutomotiveByCountry (@PathParam("country")String country);
	
	@GET
	@Path("/variable/{variable}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAutomotiveByVariable (@PathParam("variable")String variable);
	
	@GET
	@Path("/type/{type}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAutomotiveByType (@PathParam("type")String type);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAutomotiveByYear (@PathParam("year")String year);
	
	@GET
	@Path("/value/{value}")
	@Produces({MediaType.APPLICATION_JSON})
	String getAutomotiveByValue (@PathParam("value")String value);
	
	
}
