package com.protocol;

import java.io.IOException;
import java.net.MalformedURLException;

import com.model.DownloadInfo;

/*
 * This is an interface to have common methods to be implemented by
 *  all the protocols concrete implementation.
 */
public interface IProtocol {

	/**
	 * This method will be implemented by all the concrete implementations of
	 * protocols to download a particular file.
	 * 
	 * @param -downloadInfo
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 * 
	 */
	public void downloadFile(DownloadInfo downloadInfo) throws MalformedURLException, IOException;

}
