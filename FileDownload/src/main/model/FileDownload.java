package main.model;

import java.io.IOException;
import java.net.MalformedURLException;

import main.protocol.IProtocol;
import main.utility.Constants;
import main.utility.Protocols;
import main.utility.FileUtil;

public class FileDownload implements Runnable{

	private Protocols protocol;
	
	private String url;
		
	private String downloadedFileName;
	
	private String downloadedLocation;
	
	private int  timeout = -1;
	
	private String username;
	
	private String password;

	
	public FileDownload(String url) {
		super();
		this.url = url;
	}
	
	
	public FileDownload(String url, String downloadedLocation) {
		super();
		this.url = url;
		this.downloadedLocation = downloadedLocation;
	}
	
	public FileDownload(String url, String downloadedLocation, int timeout) {
		super();
		this.url = url;
		this.downloadedLocation = downloadedLocation;
		this.timeout = timeout;
	}


	public Protocols getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocols protocol) {
		this.protocol = protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDownloadedFileName() {
		return downloadedFileName;
	}

	public void setDownloadedFileName(String downloadedFileName) {
		this.downloadedFileName = downloadedFileName;
	}

	public String getDownloadedLocation() {
		return downloadedLocation;
	}

	public void setDownloadedLocation(String downloadedLocation) {
		this.downloadedLocation = downloadedLocation;
	}
	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void run(){	
		//System.out.println("In Download:");
		FileUtil.parse(url, this);
		if(downloadedLocation==null){
			downloadedLocation = Constants.DOWNLOAD_LOCATION;
		}
		if(timeout == -1){
			timeout = Constants.DEFAULT_READ_TIMEOUT;
		}
		IProtocol protocolImpl = ProtocolFactory.getProtocolImpl(protocol);
		if(protocolImpl!=null){
			try {
				protocolImpl.download(url, this);
			} catch(MalformedURLException m){
				System.err.println(m.getMessage());			}
			catch (IOException e) {
				System.err.println(e.getMessage());
			}
			catch (Exception e){
				System.err.println(e.getMessage());
			}
		}
		
	}
	
	
	
	
}
