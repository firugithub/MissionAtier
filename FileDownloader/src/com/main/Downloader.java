package com.main;

/*
 * This class is the thread that will be spawned for each url required to be read.
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.constants.Constants;
import com.model.DownloadInfo;
import com.protocol.IProtocol;
import com.protocol.ProtocolImplProvider;
import com.util.FileUtilities;
import com.util.PropertiesUtil;

public class Downloader implements Runnable {
	private String url;
	private String downloadLocation;
	private int timeout = Integer.MIN_VALUE;
	private String userName;
	private String passWord;

	public Downloader(String url, String downloadLocation) {
		super();
		this.url = url;
		this.downloadLocation = downloadLocation;
	}

	public Downloader(String url, String downloadLocation, int timeout) {
		super();
		this.url = url;
		this.downloadLocation = downloadLocation;
		this.timeout = timeout;
	}

	public Downloader(String url, String downloadLocation, String userName, String passWord) {
		super();
		this.url = url;
		this.downloadLocation = downloadLocation;
		this.userName = userName;
		this.passWord = passWord;
	}

	@Override
	public void run() {
		DownloadInfo downloadInfo;
		if (timeout == Integer.MIN_VALUE) {
			downloadInfo = new DownloadInfo(url, downloadLocation, Constants.READ_DEFAULT_TIMEOUT);
		} else {
			downloadInfo = new DownloadInfo(url, downloadLocation, timeout);
		}
		downloadInfo.setUsername(userName);
		downloadInfo.setPassword(passWord);
		try {
			FileUtilities.parse(downloadInfo);
		} catch (URISyntaxException e) {
			System.err.println(PropertiesUtil.getProperty("UrlParseError") + e.getMessage());
		}

		IProtocol protocol = ProtocolImplProvider.getProtocolImpl(downloadInfo.getProtocol());
		if (protocol != null) {
			try {
				protocol.downloadFile(downloadInfo);
			} catch (MalformedURLException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

}
