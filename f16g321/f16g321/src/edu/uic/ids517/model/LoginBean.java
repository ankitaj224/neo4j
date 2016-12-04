package edu.uic.ids517.model;

import java.util.Date;
import java.sql.ResultSet;

public class LoginBean {
	private String userName;
	private String password;
	private String role;
	private Date lastLoginTime;
	private String lastLoginIP;
	private DBAccessBean dBAccessBean = null;
	private String message = "";
	private Boolean renderMessage;

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getRenderMessage() {
		return renderMessage;
	}

	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validate() {
		try {
			dBAccessBean = new DBAccessBean();
			String status = dBAccessBean.connect();
			if (status.equals("SUCCESS") && dBAccessBean.getRenderMessage() == false
					&& dBAccessBean.getMessage().equals("")) {

				dBAccessBean.execute("select password , role from f16g321_user where user_name ='" + userName + "'");
				ResultSet rs = dBAccessBean.getResultSet();
				if (rs != null) {
					if (rs.next()) {

						if (!rs.getString(1).equals(password)) {
							renderMessage = true;
							message = "Invalid Password";
							return "FAIL";
						} else {
							role = rs.getString(2);
							java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String currentTime = sdf.format(lastLoginTime);
							dBAccessBean.execute("update f16g321_user set last_logintime = '" + currentTime
									+ "' ,last_login_ip ='" + lastLoginIP + "' where user_name ='" + userName + "';");

						}
					} else {
						renderMessage = true;
						message = "Invalid User Name";
						return "FAIL";
					}

				}
			} else {
				renderMessage = true;
				message = dBAccessBean.getMessage();
				return "FAIL";

			}
			return "SUCCESS";
		} catch (Exception e) {
			renderMessage = true;
			message = "Exception occurred: " + e.getMessage();
			e.printStackTrace();
			return "FAIL";
		} finally {
			dBAccessBean.close();
		}
	}

}
