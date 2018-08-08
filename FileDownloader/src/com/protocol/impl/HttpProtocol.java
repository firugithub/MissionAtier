package com.protocol.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.model.DownloadInfo;
import com.protocol.IProtocol;
import com.util.PropertiesUtil;

public class HttpProtocol implements IProtocol {

	@Override
	public void downloadFile(DownloadInfo downloadInfo) throws IOException {
		URL sourceUrl = null;
		try {
			sourceUrl = new URL(downloadInfo.getUrl());
		} catch (MalformedURLException e) {
			throw new MalformedURLException(PropertiesUtil.getProperty("IncorrectHTTPUrl"));
		}
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		File outputFile = null;
		try {
			URLConnection connection = sourceUrl.openConnection();
			connection.setReadTimeout(downloadInfo.getTimeout());
			connection.setConnectTimeout(2 * downloadInfo.getTimeout());

			inputStream = connection.getInputStream();
			outputFile = new File(downloadInfo.getDownloadLocation() + "/" + downloadInfo.getDownloadName());
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			fileOutputStream = new FileOutputStream(outputFile, false);

			byte[] buffer = new byte[4096];
			int len, bytesRead = 0;
			while ((len = inputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, len);
				bytesRead += len;
				if (bytesRead > 1024 * 1024) {
					bytesRead = 0;
					fileOutputStream.flush();
				}
			}
		} catch (IOException e) {
			if (null != outputFile) {
				outputFile.delete();
			}
			throw new IOException(PropertiesUtil.getProperty("InterruptedExceptionOrigin"));
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				throw new IOException(PropertiesUtil.getProperty("InterruptedExceptionOrigin"));
			} finally {
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						throw new IOException(PropertiesUtil.getProperty("InterruptedExceptionDestination"));
					}
				}
			}
		}

	}

}
