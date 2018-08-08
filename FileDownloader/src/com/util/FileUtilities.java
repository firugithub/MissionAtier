package com.util;

/*
 * This class is a util class that -
 * 1)validates the URL given for download. 
 * 2)Checks whether the protocol is supported by the program or not.
 * 3) Forms the downloaded file name .
 */
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.constants.Constants;
import com.constants.SupportedProtocol;
import com.model.DownloadInfo;

public class FileUtilities {
	public static void parse(DownloadInfo downloadInfo) throws URISyntaxException {
		if (null == downloadInfo) {
			throw new IllegalArgumentException(PropertiesUtil.getProperty("DownloadInfoNull"));
		}
		URI fileUrl = new URI(downloadInfo.getUrl());
		if (isValidURL(fileUrl)) {
			SupportedProtocol protocol = SupportedProtocol.valueOf(fileUrl.getScheme().toUpperCase());
			if (protocol == null) {
				throw new UnsupportedOperationException(
						PropertiesUtil.getProperty("UnsupportedProtocol") + "-" + fileUrl.getScheme());
			}
			downloadInfo.setProtocol(protocol);
			downloadInfo.setDownloadName(generateFileName(fileUrl.getScheme(), fileUrl.getPath(), downloadInfo));
			downloadInfo.setUri(fileUrl);
		} else {
			throw new IllegalArgumentException(PropertiesUtil.getProperty("IllegalURLFormat"));
		}
	}

	public static boolean isValidURL(URI fileUrl) {

		if (null == fileUrl.getAuthority() || fileUrl.getAuthority().length() < 1 || null == fileUrl.getScheme()
				|| fileUrl.getScheme().length() < 1 || null == fileUrl.getPath() || fileUrl.getPath().length() < 1) {
			return false;
		}

		return true;
	}

	public static String generateFileName(String protocolName, String filePath, DownloadInfo downloadInfo) {
		String[] filePathSplit = filePath.split("/");
		String fileName = filePathSplit[filePathSplit.length - 1];
		downloadInfo.setFileName(fileName);
		String extension = getFileExtension(fileName);
		if (null != extension && extension.length() > 0) {
			return fileName.substring(0, fileName.lastIndexOf(".")) + "-" + getDateTime() + "-" + protocolName + "."
					+ extension;
		} else {
			return fileName + "-" + getDateTime() + "-" + protocolName + Constants.DEFAULT_FILE_TYPE;
		}

	}

	private final static String getDateTime() {
		DateFormat df = new SimpleDateFormat(Constants.TIMESTAMP_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone(Constants.TIMEZONE));
		return df.format(new Date());
	}

	public static String getFileExtension(String fileName) {
		String name = fileName;
		try {
			if (fileName.contains(".")) {
				return name.substring(name.lastIndexOf(".") + 1);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
	}
}