package edu.uic.ids517.model;
public class DBAccessInfoBean {

	private String userName;
	private String password;
	private String dbms;
	private String dbmsHost;
	private String dBSchema;

	public DBAccessInfoBean() {
		this.userName = "s16g40";
		this.password = "s16g40FpqU5";
		this.dbms = "MySQL";
		this.dbmsHost = "131.193.209.57";
		this.dBSchema = "s16g40";

	}

	public DBAccessInfoBean(String userName, String password, String dbms, String dBSchema ,  String dbmsHost) {

		this.userName = userName;
		this.password = password;
		this.dbms = dbms;
		this.dbmsHost = dbmsHost;
		this.dBSchema = dBSchema;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dbms
	 */
	public String getDbms() {
		return dbms;
	}

	/**
	 * @param dbms
	 *            the dbms to set
	 */
	public void setDbms(String dbms) {
		this.dbms = dbms;
	}

	/**
	 * @return the dbmsHost
	 */
	public String getDbmsHost() {
		return dbmsHost;
	}

	/**
	 * @param dbmsHost
	 *            the dbmsHost to set
	 */
	public void setDbmsHost(String dbmsHost) {
		this.dbmsHost = dbmsHost;
	}

	/**
	 * @return the dBSchema
	 */
	public String getDBSchema() {
		return dBSchema;
	}

	/**
	 * @param dBSchema
	 *            the dBSchema to set
	 */
	public void setDBSchema(String dBSchema) {
		this.dBSchema = dBSchema;
	}

}
