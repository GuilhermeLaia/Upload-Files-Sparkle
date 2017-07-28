package br.com.sparkle.api.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author guilhermemedeiros
 * Class Domain FileDomain 
 */
@JsonIgnoreProperties({"file"})
public class FileDomain implements Serializable {
	
	private static final long serialVersionUID = -5586749468914757030L;
	
	private String fileName;
	private byte[] file;
	private String fileType;
	private Long timeUpload;
	private String sizeBlocksFile;
	private Integer filePart;
	private Integer filePartTotal;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getTimeUpload() {
		return timeUpload;
	}
	public void setTimeUpload(Long timeUpload) {
		this.timeUpload = timeUpload;
	}
	public String getSizeBlocksFile() {
		return sizeBlocksFile;
	}
	public void setSizeBlocksFile(String sizeBlocksFile) {
		this.sizeBlocksFile = sizeBlocksFile;
	}
	public Integer getFilePart() {
		return filePart;
	}
	public void setFilePart(Integer filePart) {
		this.filePart = filePart;
	}
	public Integer getFilePartTotal() {
		return filePartTotal;
	}
	public void setFilePartTotal(Integer filePartTotal) {
		this.filePartTotal = filePartTotal;
	}
	
	
}
