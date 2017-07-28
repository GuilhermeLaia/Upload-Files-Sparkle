package br.com.sparkle.api.service;

import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.sparkle.api.domain.FileDomain;
import br.com.sparkle.api.domain.UploadFileDomain;
import br.com.sparkle.api.exception.StorageFileException;

/**
 * @author guilhermemedeiros
 * Interface Service UploadFileService 
 */
public interface UploadFileService {
	
	public UploadFileDomain uploadFile(MultipartHttpServletRequest request) throws StorageFileException;
	
	public void downloadFile(HttpServletResponse response, String idFile) throws StorageFileException;
	
	public LinkedList<FileDomain> loadFiles() throws StorageFileException;
	

}
