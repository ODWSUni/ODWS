package it.univaq.odws.maven.rest.economy;

import java.io.ByteArrayOutputStream;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;

public class SustainabilityImpl implements Sustainability{
	private static final String SUSTAINABILITY_RDF_RESOURCE = "sustainability.rdf";
	
	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(SUSTAINABILITY_RDF_RESOURCE);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}
	
	public String getSustainabilityByYear(String year) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/sost#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?sustainability aut:country ?country. ").append(System.lineSeparator());
		query.append("      ?sustainability aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?sustainability aut:type ?type.").append(System.lineSeparator());
		query.append("      ?sustainability aut:year ?year.").append(System.lineSeparator());
		query.append("      ?sustainability aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(regex(?year, \"" + year + "\", \"i\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	
	public String getSustainabilityByCountry(String country) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/sost#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?sustainability aut:country ?country.").append(System.lineSeparator());
		query.append("      ?sustainability aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?sustainability aut:type ?type.").append(System.lineSeparator());
		query.append("      ?sustainability aut:year ?year.").append(System.lineSeparator());
		query.append("      ?sustainability aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?country), \"" + country.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getSustainabilityByType(String type) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/sost#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value.").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?sustainability aut:country ?country.").append(System.lineSeparator());
		query.append("      ?sustainability aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?sustainability aut:type ?type.").append(System.lineSeparator());
		query.append("      ?sustainability aut:year ?year.").append(System.lineSeparator());
		query.append("      ?sustainability aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?type), \"" + type.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getSustainabilityByVariable(String variable) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/sost#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?sustainability aut:country ?country.").append(System.lineSeparator());
		query.append("      ?sustainability aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?sustainability aut:type ?type.").append(System.lineSeparator());
		query.append("      ?sustainability aut:year ?year.").append(System.lineSeparator());
		query.append("      ?sustainability aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?variable), \"" + variable.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getSustainabilityByValue(String value) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/sost#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?sustainability aut:country ?country. ").append(System.lineSeparator());
		query.append("      ?sustainability aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?sustainability aut:type ?type.").append(System.lineSeparator());
		query.append("      ?sustainability aut:year ?year.").append(System.lineSeparator());
		query.append("      ?sustainability aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(regex(?value, \"" + value + "\", \"i\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
}

