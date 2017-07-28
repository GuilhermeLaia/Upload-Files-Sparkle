package br.com.sparkle.api.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.sparkle.api.domain.FileDomain;
import br.com.sparkle.api.domain.UploadFileDomain;
import br.com.sparkle.api.exception.StorageFileException;
import br.com.sparkle.api.service.UploadFileService;


/**
 * @author guilhermemedeiros
 * Class Service UploadFileServiceImpl responsible for business rules
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {
	
	private UploadFileDomain uploadFileDomain = new UploadFileDomain();

	public UploadFileDomain uploadFile(MultipartHttpServletRequest request) throws StorageFileException {
		
		MultipartFile file = null;
		try {	
			Iterator<String> itr =  request.getFileNames();
	        while(itr.hasNext()){
	        	
	        	file = request.getFile(itr.next()); 
	        
	            if (file.isEmpty()) {
	                throw new StorageFileException("Failed to store empty file " + file.getOriginalFilename());
	            }
	            	          
	            int contFile = 0;
	            for(FileDomain fileStored: uploadFileDomain.getFiles()){
	            	if(fileStored.getFileName() != null 
	            			&& fileStored.getFileName().equals(file.getOriginalFilename())){
	            		++contFile;
	            	}
	            }
	            FileDomain fileDomain = new FileDomain();
	            fileDomain.setFilePart(contFile+1);	 
	            fileDomain.setFileName(file.getOriginalFilename());
	            fileDomain.setSizeBlocksFile(file.getSize()/1024+ "KB");
	            fileDomain.setFileType(file.getContentType());
	            fileDomain.setFile(file.getBytes());
	            
	            for(FileDomain fileStored: uploadFileDomain.getFiles()){
	            	if(fileStored.getFileName() != null 
	            			&&fileStored.getFileName().equals(file.getOriginalFilename())){
	            		fileStored.setFilePartTotal(contFile+1);
	            	}
	            }
	            
	            uploadFileDomain.getFiles().add(fileDomain);
	            FileCopyUtils.copy(file.getBytes(), new FileOutputStream("src/main/resources/files/"+file.getOriginalFilename()));
	        }
        } catch (IOException e) {
            throw new StorageFileException("Failed to store file " + file.getOriginalFilename(), e);
        }
		
		return uploadFileDomain;
		
	}
 
	public void downloadFile(HttpServletResponse response, String idFile) throws StorageFileException {
		try {
			FileDomain getFile = uploadFileDomain.getFiles().get(Integer.parseInt(idFile));
			response.setContentType(getFile.getFileType());
            response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
            FileCopyUtils.copy(getFile.getFile(), response.getOutputStream());
        } catch (IOException e) {
            throw new StorageFileException("Failed to read stored files", e);
        }
	}

	@Override
	public LinkedList<FileDomain> loadFiles() throws StorageFileException {
		return uploadFileDomain.getFiles();
	}


}
