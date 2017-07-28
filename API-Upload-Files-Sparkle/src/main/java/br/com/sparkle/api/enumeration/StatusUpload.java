package br.com.sparkle.api.enumeration;

/**
 * @author guilhermemedeiros
 * Enum StatusUpload Status (In progress, fail, successs)
 */
public enum StatusUpload {

	IN_PROGRESS("In Progress"),
	FAIL("Fail"),
	SUCCESS("Success");
	
	private String description;
	
	private StatusUpload(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
