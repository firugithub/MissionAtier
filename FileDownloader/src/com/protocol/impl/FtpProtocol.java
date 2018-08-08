package com.protocol.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import com.model.DownloadInfo;
import com.protocol.IProtocol;
import com.util.PropertiesUtil;

public class FtpProtocol implements IProtocol {
	FTPClient ftp = null;

	@Override
	public void downloadFile(DownloadInfo downloadInfo) throws IOException {
		String user = downloadInfo.getUsername();
		String pass = downloadInfo.getPassword();
		if (user == null || pass == null) {
			throw new IllegalArgumentException(PropertiesUtil.getProperty("FtpCredenetialsNull"));
		}
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fileOutputStream = null;
		File downloadFile1 = null;
		try {
			ftpClient.setDefaultTimeout(downloadInfo.getTimeout());
			ftpClient.connect(downloadInfo.getUri().getAuthority());
			if (!ftpClient.login(user, pass)) {
				throw new IllegalArgumentException(PropertiesUtil.getProperty("FtpCredenetialsIncorrect"));
			}
			downloadFile1 = new File(downloadInfo.getDownloadLocation() + "/" + downloadInfo.getDownloadName());
			if (!downloadFile1.exists()) {
				downloadFile1.createNewFile();
			}
			fileOutputStream = new FileOutputStream(downloadFile1, false);
			boolean success = ftpClient.retrieveFile(
					downloadInfo.getUri().getPath().substring(downloadInfo.getUri().getPath().indexOf("/") + 1),
					fileOutputStream);

			if (success) {
				System.out.println("File :" + downloadInfo.getFileName() + " has been downloaded successfully.");
			}
		} catch (IOException ex) {
			if (null != downloadFile1) {
				downloadFile1.delete();
			}
			throw new IOException(PropertiesUtil.getProperty("InterruptedExceptionOrigin"));
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				throw new IOException(PropertiesUtil.getProperty("InterruptedException"));
			}
		}
	}

}
