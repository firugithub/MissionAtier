package main;

import main.model.FileDownload;

public class Runner {

	public static void main(String[] args){
		String file1 = "http://my.file.com/file";
		String file2 = "ftp://other.file.com/other";
		String file3 = "sftp://and.also.this/ending";
		
		String location = "/Users/utkarshgoel/Documentss";
		
		FileDownload fileDownload1 = new FileDownload(file1, location);
		FileDownload fileDownload2 = new FileDownload(file2, location);
		FileDownload fileDownload3 = new FileDownload(file3, location);
		
		Thread thread1 = new Thread(fileDownload1);
		//thread1.start();
		Thread thread2 = new Thread(fileDownload2);
		thread2.start();
		Thread thread3 = new Thread(fileDownload3);
		//thread3.start();
		
		}
}
