package br.com.sparkle.api.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.sparkle.api.domain.FileDomain;
import br.com.sparkle.api.domain.UploadFileDomain;
import br.com.sparkle.api.service.UploadFileService;

/**
 * @author guilhermemedeiros
 * Class Controller UploadFileController using service UploadFileService
 */
@RestController
public class UploadFileController {

	
	@Autowired
	private UploadFileService service;
	
	@RequestMapping(
			value = "/api/uploadFile", 
			method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@CrossOrigin
	public @ResponseBody UploadFileDomain uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		return service.uploadFile(request);
	}
	
	@RequestMapping(
			value = "/api/downloadFile/{idFile}", 
			method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@CrossOrigin
	public void loadFile(HttpServletResponse response, @PathVariable String idFile) throws Exception {
		service.downloadFile(response, idFile);
	}
	
	@RequestMapping(
			value = "/api/loadFiles", 
			method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@CrossOrigin
	public @ResponseBody LinkedList<FileDomain> loadFiles() throws Exception {
		return service.loadFiles();
	}
		
}
