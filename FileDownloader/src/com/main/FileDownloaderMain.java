package com.main;

/*
 * This is the main class to run the file downloader program. It spawns that many number of threads equal to 
 * the number of url's provided.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.constants.Constants;
import com.util.PropertiesUtil;

public class FileDownloaderMain {

	public static void main(String[] args) {
		String[] url = { "ftp://localhost/Desktop/settings.xml", "ftp://10.10.112.216/output.txt",
				"ftp://localhost/cf.txt", "http://norvig.com/big.txt" };
		if (url.length < 1) {
			System.err.println(PropertiesUtil.getProperty("UrlListEmpty"));
		} else {
			String downloadLocation = null;
			if (args.length > 0) {
				downloadLocation = args[0];
			}
			if (null == downloadLocation) {
				downloadLocation = Constants.DEFAULT_FILE_DOWNLOAD_LOCATION;
			}
			/*
			 * Please Note - The username and password for ftp is hardcoded as
			 * of now but it can be changed so to accept credentials on per link
			 * basis.
			 * 
			 */
			ExecutorService es = Executors.newFixedThreadPool(url.length);
			for (String link : url) {
				Downloader downloader = new Downloader(link, downloadLocation, "userName", "password");
				es.execute(downloader);
			}
			es.shutdown();

		}
	}
}
