package main.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.model.FileDownload;

public class FileUtil {

	public static void parse(String url, FileDownload file){
		
		if(url==null){
			throw new IllegalArgumentException("url can't be null");
		}
		
		String[] urlSplit = url.split(":");
		
		if(urlSplit.length!=2){
			throw new IllegalArgumentException("Invalid format url:"+url);
		}else{
			urlSplit[0] = urlSplit[0].toUpperCase();
			Protocols protocol = Protocols.valueOf(urlSplit[0]);
			if(protocol == null){
				throw new UnsupportedOperationException("Download not possible for Protocol type:"+urlSplit[0]);
			}
			file.setProtocol(protocol);
			
			String[] urlName = urlSplit[1].split("/");
			int len = urlName.length;
			if(len<3){
				throw new IllegalArgumentException("Invalid format url:"+url);
			}
			String downloadedFile = protocol.name()+"_"+getTimeStamp()+"_"+urlName[len-1];
			String[] downloadedFiles = downloadedFile.split(".");
			if(downloadedFiles.length==2){
				file.setDownloadedFileName(downloadedFile);
			}else{
				file.setDownloadedFileName(downloadedFile + Constants.FILE_TYPE);
			}
						
		}
	}
	
	public static String getTimeStamp() {
	  DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	  String timeStamp = format.format(new Date());
	  return timeStamp;
	}
	
}
