package com.adbms.uic;

public class MessageBean {
	private String errorMessage="";
	private boolean renderErrorMessage=false;
	private String successMessage="";
	private boolean renderSuccessMessage=false;

	public boolean isRenderErrorMessage() {
		return renderErrorMessage;
	}

	public void setRenderErrorMessage(boolean renderErrorMessage) {
		this.renderErrorMessage = renderErrorMessage;
	}

	public MessageBean() {
		super();
		errorMessage = "";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
	
	public void resetAll(){
		errorMessage = "";
		renderErrorMessage = false;
		successMessage ="";
		renderSuccessMessage = false;
	}
}
