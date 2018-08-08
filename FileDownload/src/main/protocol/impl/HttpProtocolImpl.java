package main.protocol.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import main.model.FileDownload;
import main.protocol.IProtocol;

public class HttpProtocolImpl implements IProtocol {

	@Override
	public void download(String source, FileDownload file) throws MalformedURLException,IOException{
		int timeout = file.getTimeout();
		String destination = file.getDownloadedLocation()+file.getDownloadedFileName();
		URL url = null;
		try {
			url = new URL(source);
		} catch (MalformedURLException e) {
			throw new MalformedURLException("Invalid URL:"+source);
		}
		InputStream is = null;
	    FileOutputStream fos = null;

	    try {
	        URLConnection urlConn = url.openConnection();
	        urlConn.setReadTimeout(timeout);
	        urlConn.setConnectTimeout(2*timeout);
	        
	        is = urlConn.getInputStream();
	        File destinationFile = new File(destination);
	        if(!destinationFile.exists()){
	        	destinationFile.createNewFile();
	        }
	        fos = new FileOutputStream(destinationFile,false);   
	        
	        byte[] buffer = new byte[4096];              
	        int len,bytesRead=0;	        
	        while ((len = is.read(buffer)) > 0) {  
	            fos.write(buffer, 0, len);
	            bytesRead += len;
	            if (bytesRead > 1024 * 1024) { 
	            	bytesRead = 0;
	            	fos.flush();
	            }
	        }
	    } catch (IOException e) {
			throw new IOException("File download interrupted from source:"+source);
		} finally {	
	        try {
	            if (is != null) {
	                is.close();
	            }
	        } catch (IOException e) {
	        	throw new IOException("File download interrupted from source:"+source);
			} finally {
	            if (fos != null) {
	                try {
						fos.close();
					} catch (IOException e) {
						throw new IOException("File download interrupted from destination:"+destination);
					}
	            }
	        }
	    }
		
	}

}
