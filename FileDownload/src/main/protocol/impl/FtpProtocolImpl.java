package main.protocol.impl;

import main.model.FileDownload;
import main.protocol.IProtocol;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FtpProtocolImpl implements IProtocol {

	@Override
	public void download(String source, FileDownload file) throws IllegalArgumentException,IOException{
		String username = file.getUsername();
		String password = file.getPassword();
		String destination = file.getDownloadedLocation()+file.getDownloadedFileName();	
		String[] sources = source.split("/");
		source = "";
		for(int i=0;i<(sources.length-1);i++){
			source = source + sources[i];
		}
		String fileName = sources[sources.length-1];
		
		FTPClient client = new FTPClient(); 
	    FileOutputStream fos = null; 
	    if(username==null || password==null){
	    	throw new IllegalArgumentException("Need username and password for downloading file from FTP server");
	    }
	    try { 
	      client.connect(source);
	      client.login( username , password); 
	      File destinationFile = new File(destination);
	        if(!destinationFile.exists()){
	        	destinationFile.createNewFile();
	        }
	     fos = new FileOutputStream(destinationFile,false);   

	      // Download file from FTP server 
	      client.retrieveFile("/" + fileName, fos); 

	    } catch (IOException e) { 
	    	throw new IOException("File download interrupted from source:"+source); 
	    } finally { 
	      try { 
	        if (fos != null) { 
	          fos.close(); 
	        } 
	        client.disconnect(); 
	      } catch (IOException e) {
	    	  throw new IOException("File download interrupted from destination:"+destination);
	      } 
	    }
		
	}

}
