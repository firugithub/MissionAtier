package com.model;

import java.net.URI;
/*
 * This class is the core download information object. It contains fields to support download 
 * process for ex- protocol , timeout,url,download location,download name etc.
 */
import java.util.Objects;

import com.constants.SupportedProtocol;
import com.util.PropertiesUtil;

public class DownloadInfo {

	private SupportedProtocol protocol;

	private String url;

	private String downloadName;

	private String downloadLocation;

	private int timeout = Integer.MIN_VALUE;

	private String username;

	private String password;

	private String fileName;
	private URI uri;

	public DownloadInfo(String url, String downloadLocation) {
		super();
		checkNotNull(url, downloadLocation);
		this.url = url;
		this.downloadLocation = downloadLocation;
	}

	public DownloadInfo(String url, String downloadLocation, int timeout) {
		super();
		checkNotNull(url, downloadLocation);
		this.url = url;
		this.downloadLocation = downloadLocation;
		this.timeout = timeout;
	}

	private void checkNotNull(String url, String downloadLocation) {
		Objects.requireNonNull(url, PropertiesUtil.getProperty("UrlNull"));
		Objects.requireNonNull(downloadLocation, PropertiesUtil.getProperty("DownloadLocationNull"));
	}

	public SupportedProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(SupportedProtocol protocol) {
		this.protocol = protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDownloadName() {
		return downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public String getDownloadLocation() {
		return downloadLocation;
	}

	public void setDownloadLocation(String downloadLocation) {
		this.downloadLocation = downloadLocation;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

}
