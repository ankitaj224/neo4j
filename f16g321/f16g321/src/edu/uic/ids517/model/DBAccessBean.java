package edu.uic.ids517.model;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class DBAccessBean {
	
	

	private Connection connection;
	private DatabaseMetaData databaseMetaData;
	private Statement statement;
	private ResultSet resultSet, rs;
	private ResultSetMetaData resultSetMetaData;
	private Result result;
	private Boolean status;
	private static final String[] TABLE_TYPES = { "TABLE", "VIEW" };
	private String jdbcDriver;
	private String url;
	private DBAccessInfoBean dBAccessInfoBean;
	private static final String MY_SQL = "MySQL";
	private static final String DB2 = "DB2";
	private static final String ORACLE = "Oracle";
	private String message = "";
	private Boolean renderMessage = false;
	
	// constants for SQLException
	private static final String ACCESS_DENIED = "28000";
	private static final String INVALID_DB_SCHEMA = "42000";
	private static final String TIMEOUT = "08S01";
	private static final String INVALID_PORT = "08001";
	
	public DBAccessBean(){
		
		dBAccessInfoBean = new DBAccessInfoBean ();
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public Boolean getRenderMessage() {
		return renderMessage;
	}

	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void loginInfo(String userName, String password, String dbms, String dbSchema, String host) {

		dBAccessInfoBean = new DBAccessInfoBean(userName, password, dbms, dbSchema, host);

	}

	public String getMessage() {
		return message;
	}

	public String connect() {

		if (MY_SQL.equals(dBAccessInfoBean.getDbms())) {
			jdbcDriver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://" + dBAccessInfoBean.getDbmsHost() + ":3306/" + dBAccessInfoBean.getDBSchema() + "?&useSSL=false";
		} else if (DB2.equals(dBAccessInfoBean.getDbms())) {
			jdbcDriver = "com.ibm.db2.jcc.DB2Driver";
			url = "jdbc:db2://" + dBAccessInfoBean.getDbmsHost() + ":50000/" + dBAccessInfoBean.getDBSchema();
		} else if (ORACLE.equals(dBAccessInfoBean.getDbms())) {
			jdbcDriver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@" + dBAccessInfoBean.getDbmsHost() + ":1521:" + dBAccessInfoBean.getDBSchema();
		}
		try {

			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(url, dBAccessInfoBean.getUserName(), dBAccessInfoBean.getPassword());
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			databaseMetaData = connection.getMetaData();
			status = Boolean.TRUE;
			return "SUCCESS";
		} catch(ClassNotFoundException ce) {
			message =  "Database: " + dBAccessInfoBean.getDbms() + " not supported.";
			renderMessage = true;
			return "FAIL";
		} catch(SQLException se) {
			if (se.getSQLState().equals(ACCESS_DENIED))
			{
				message = "Error Code: " + se.getErrorCode() + "\n" +
						"SQL State: " + se.getSQLState() + "\n" +
						"Message :" + se.getMessage() + "\n\n" +
						"Invalid credentials!";
			}
			else if (se.getSQLState().equals(INVALID_DB_SCHEMA))
			{
				message = "Error Code: " + se.getErrorCode() + "\n" +
						"SQL State: " + se.getSQLState() + "\n" +
						"Message :" + se.getMessage() + "\n\n" +
						"Invalid database schema!";
			}
			else if (se.getSQLState().equals(TIMEOUT))
			{
				message = "Error Code: " + se.getErrorCode() + "\n" +
						"SQL State: " + se.getSQLState() + "\n" +
						"Message :" + se.getMessage() + "\n\n" +
						"Check host & port properly!";
			}
			else if (se.getSQLState().equals(INVALID_PORT))
			{
				message = "Error Code: " + se.getErrorCode() + "\n" +
						"SQL State: " + se.getSQLState() + "\n" +
						"Message :" + se.getMessage() + "\n\n" +
						"Invalid port. It must contain only digits!";
			}
			else {
				message = "Error Code: " + se.getErrorCode() + "\n" +
						"SQL State: " + se.getSQLState() + "\n" +
						"Message :" + se.getMessage() + "\n\n" +
						"Unknown SQL Exception occurred!";
			}
			renderMessage = true;
			return "FAIL";
		} catch(Exception e) {
			message = "Exception occurred: " + e.getMessage();
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException se) {
					message = "Error Code: " + se.getErrorCode() + "\n" +
							"SQL State: " + se.getSQLState() + "\n" +
							"Message :" + se.getMessage() + "\n\n" +
							"SQLException occurred. Couldn't close connection.";
				}
			}
			renderMessage = true;
			return "FAIL";
		}
    }

	

	public void close() {
		try {
			if (resultSet != null) {

				resultSet.close();
			}
			if (statement != null) {

				statement.close();
			}
			if (connection != null) {

				connection.close();

			}
			status = Boolean.FALSE;
		} catch (SQLException e) {
			// TODO
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		}
	}

	public List<String> tableList() {
		List<String> tableList = null;
		try {
			if (databaseMetaData != null) {
				resultSet = databaseMetaData.getTables(null, dBAccessInfoBean.getUserName(), null, TABLE_TYPES);
				resultSet.last();
				int numberOfRows = resultSet.getRow();
				tableList = new ArrayList(numberOfRows);
				resultSet.beforeFirst();
				String tableName = "";
				if (resultSet != null) {
					while (resultSet.next()) {
						tableName = resultSet.getString("TABLE_NAME");
						if (!dBAccessInfoBean.getDbms().equalsIgnoreCase("oracle") || tableName.length() < 4)
							tableList.add(tableName);
						else if (!tableName.substring(0, 4).equalsIgnoreCase("BIN$"))
							tableList.add(tableName);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
			close();
		}

		return tableList;
	}

	public List<String> columnList(String tableName) {
		List<String> columnList = new ArrayList<String>();
		try {
			if (databaseMetaData != null) {
				resultSet = databaseMetaData.getColumns(null, dBAccessInfoBean.getDBSchema(), tableName, null);

				String columnName = "";
				if (resultSet != null) {
					while (resultSet.next()) {
						columnName = resultSet.getString("COLUMN_NAME");
						columnList.add(columnName);
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
			close();
		}
		return columnList;
	}

	public void execute(String query) {
		try {
			if (connection != null && statement != null) {
				if (query.toLowerCase().startsWith("select")) {
					resultSet = statement.executeQuery(query);
					resultSetMetaData = resultSet.getMetaData();
					int numOfCols = resultSetMetaData.getColumnCount();
					int numOfRows = 0;

					if (resultSet != null) {
						for (int i = 0; i < numOfCols; i++) {
							//System.out.print(String.format("%-45s ", resultSetMetaData.getColumnName(i + 1)));
						}
						
					}
					

				} else {
					// UPDATE,INSERT,DELETE
					statement.executeUpdate(query);
					
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
			//close();
		} 
	}



	public void generateResult() {
		if (resultSet != null) {
			result = ResultSupport.toResult(resultSet);
		}
	}
}
