package it.univaq.odws.maven.rest.economy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/generaldata")
public interface GeneralData {
	
	@GET
	@Path("/country/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	String getGeneralDataByCountry (@PathParam("country")String country);
	
	@GET
	@Path("/variable/{variable}")
	@Produces({MediaType.APPLICATION_JSON})
	String getGeneralDataByVariable (@PathParam("variable")String variable);
	
	@GET
	@Path("/type/{type}")
	@Produces({MediaType.APPLICATION_JSON})
	String getGeneralDataByType (@PathParam("type")String type);
	
	@GET
	@Path("/year/{year}")
	@Produces({MediaType.APPLICATION_JSON})
	String getGeneralDataByYear (@PathParam("year")String year);
	
	@GET
	@Path("/value/{value}")
	@Produces({MediaType.APPLICATION_JSON})
	String getGeneralDataByValue (@PathParam("value")String value);
	
	
}
