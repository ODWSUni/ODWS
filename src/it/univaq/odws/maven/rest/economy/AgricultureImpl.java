package it.univaq.odws.maven.rest.economy;

import java.io.ByteArrayOutputStream;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;

public class AgricultureImpl implements Agriculture{
	private static final String AGRICULTURE_RDF_RESOURCE = "agriculture.rdf";
	
	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(AGRICULTURE_RDF_RESOURCE);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}
	
	public String getAgricultureByYear(String year) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/agr#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?agriculture aut:country ?country. ").append(System.lineSeparator());
		query.append("      ?agriculture aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?agriculture aut:type ?type.").append(System.lineSeparator());
		query.append("      ?agriculture aut:year ?year.").append(System.lineSeparator());
		query.append("      ?agriculture aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(regex(?year, \"" + year + "\", \"i\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	
	public String getAgricultureByCountry(String country) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/agr#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?agriculture aut:country ?country.").append(System.lineSeparator());
		query.append("      ?agriculture aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?agriculture aut:type ?type.").append(System.lineSeparator());
		query.append("      ?agriculture aut:year ?year.").append(System.lineSeparator());
		query.append("      ?agriculture aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?country), \"" + country.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getAgricultureByType(String type) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/agr#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value.").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?agriculture aut:country ?country.").append(System.lineSeparator());
		query.append("      ?agriculture aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?agriculture aut:type ?type.").append(System.lineSeparator());
		query.append("      ?agriculture aut:year ?year.").append(System.lineSeparator());
		query.append("      ?agriculture aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?type), \"" + type.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getAgricultureByVariable(String variable) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/agr#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?agriculture aut:country ?country.").append(System.lineSeparator());
		query.append("      ?agriculture aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?agriculture aut:type ?type.").append(System.lineSeparator());
		query.append("      ?agriculture aut:year ?year.").append(System.lineSeparator());
		query.append("      ?agriculture aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(CONTAINS(LCASE(?variable), \"" + variable.toLowerCase() + "\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
	public String getAgricultureByValue(String value) {
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX aut: <http://www.economic.statistics/agr#>").append(System.lineSeparator());
		query.append("SELECT ?country ?variable ?type ?year ?value").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("      ?agriculture aut:country ?country. ").append(System.lineSeparator());
		query.append("      ?agriculture aut:variable ?variable.").append(System.lineSeparator());
		query.append("      ?agriculture aut:type ?type.").append(System.lineSeparator());
		query.append("      ?agriculture aut:year ?year.").append(System.lineSeparator());
		query.append("      ?agriculture aut:value ?value.").append(System.lineSeparator());
		query.append("      FILTER(regex(?value, \"" + value + "\", \"i\"))").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExec = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExec.execSelect();
		return convertResultSetToJSONString(resultSet);
	}
}
