package br.com.sparkle.api.domain;

import java.io.Serializable;
import java.util.LinkedList;

import br.com.sparkle.api.enumeration.StatusUpload;

/**
 * @author guilhermemedeiros
 * Class Domain UploadFileDomain 
 */
public class UploadFileDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1040958817582085094L;
	
	public UploadFileDomain(){
		this.statusUpload = StatusUpload.IN_PROGRESS;
	}
	
	private LinkedList<FileDomain> files;
	private StatusUpload statusUpload;
	
	public LinkedList<FileDomain> getFiles() {
		if(this.files == null){
			this.files = new LinkedList<>();
		}
		return files;
	}
	public void setFiles(LinkedList<FileDomain> files) {
		this.files = files;
	}
	public StatusUpload getStatusUpload() {
		return statusUpload;
	}
	public void setStatusUpload(StatusUpload statusUpload) {
		this.statusUpload = statusUpload;
	}
	

}
