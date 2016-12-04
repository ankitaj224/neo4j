package com.adbms.uic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;



public class CrimeBean {
	private FacesContext context;
	private GraphDatabaseFactory dbFactory;
	private GraphDatabaseService db;
	  private String resultString;
	  private String count="hello";
	  private String areaName;
	  private String crimeType;
	  private List<String> crimes;
	  private Boolean crimeRendered;
	  private String successMessage="";
	  private boolean renderSuccessMessage=false;
	  MessageBean messageBean;
	@PostConstruct
	public void init() {
		context = FacesContext.getCurrentInstance();
		System.out.println(context);
		Map<String, Object> m = context.getExternalContext().getSessionMap();
		messageBean = (MessageBean) m.get("messageBean");
		if(messageBean==null){
			messageBean=new MessageBean();
		}
		
		crimes = new ArrayList<String>();
		//System.out.println("working 0");
connect();

	}
	
	public void connect(){
		 dbFactory = new GraphDatabaseFactory();
		File f = new File("C:/TPNeojDB");
		 db = dbFactory.newEmbeddedDatabase(f);
		  System.out.println("worked1");
		
	}
public String addCrime(){
	
	return "SuccessAdd";

}

public String logout(){
	db.shutdown();
	return "Success";
}
public void addCrimeDB(){
	successMessage="";
	renderSuccessMessage=false;
if(!db.isAvailable(1)){
	connect();
}

	String query ="MERGE (area:AREA {name:\""+areaName+"\"})"+" MERGE (crime:PrimaryType {name:\""+crimeType+"\"}) MERGE (crime)-[:occurred]->(area)";
	Result er = db.execute(query);
	
//	System.out.println("added area "+ areaName);
	successMessage="Added Succesfully to Neo4J";
	renderSuccessMessage=true;
	//System.out.println(messageBean.isRenderSuccessMessage()+" "+messageBean.getSuccessMessage()+" ");
}

public void viewCrimeDB(){
	if(!db.isAvailable(1)){
		connect();
	}
	crimeRendered=false;
	crimes.clear();
	String query ="MATCH (a:AREA)-[r:occurred]-(c:PrimaryType)where a.name='"+areaName+"' RETURN c.name";
try{
	Result er = db.execute(query);
	String rows = "";
	  while ( er.hasNext() )
	    {
	        Map<String,Object> row = er.next();
	        
			for ( Entry<String,Object> column : row.entrySet() )
	        {
	            //rows += column.getKey() + ": " + column.getValue() + "; ";
	            crimes.add((String) column.getValue());
	        }
	       // rows += "\n";
	    }
	 
	crimeRendered=true;
}catch(Exception e){
	
}
}
public String viewCrime(){
	
	
	return "SuccessView";

}

public String getResultString() {
	return resultString;
}

public void setResultString(String resultString) {
	this.resultString = resultString;
}

public String getCount() {
	return count;
}

public void setCount(String count) {
	this.count = count;
}

public String getAreaName() {
	return areaName;
}

public void setAreaName(String areaName) {
	this.areaName = areaName;
}

public String getCrimeType() {
	return crimeType;
}

public void setCrimeType(String crimeType) {
	this.crimeType = crimeType;
}

public List<String> getCrimes() {
	return crimes;
}

public void setCrimes(List<String> crimes) {
	this.crimes = crimes;
}

public Boolean getCrimeRendered() {
	return crimeRendered;
}

public void setCrimeRendered(Boolean crimeRendered) {
	this.crimeRendered = crimeRendered;
}

public String getSuccessMessage() {
	return successMessage;
}

public void setSuccessMessage(String successMessage) {
	this.successMessage = successMessage;
}

public boolean isRenderSuccessMessage() {
	return renderSuccessMessage;
}

public void setRenderSuccessMessage(boolean renderSuccessMessage) {
	this.renderSuccessMessage = renderSuccessMessage;
}


}
