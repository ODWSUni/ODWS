package it.univaq.odws.maven.rest.economy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/transport")
public interface Transport {
	
	@GET
	@Path("/country/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getTransportByCountry (@PathParam("country")String country);
	
	@GET
	@Path("/variable/{variable}")
	@Produces({MediaType.APPLICATION_JSON})
	String getTransportByVariable (@PathParam("variable")String variable);
	
	@GET
	@Path("/type/{type}")
	@Produces({MediaType.APPLICATION_JSON})
	String getTransportByType (@PathParam("type")String type);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getTransportByYear (@PathParam("year")String year);
	
	@GET
	@Path("/value/{value}")
	@Produces({MediaType.APPLICATION_JSON})
	String getTransportByValue (@PathParam("value")String value);
	
	
}
