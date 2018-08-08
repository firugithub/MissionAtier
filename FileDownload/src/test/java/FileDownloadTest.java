package test.java;

import org.junit.Test;

import main.model.FileDownload;

public class FileDownloadTest {

	@Test
	public void test() throws InterruptedException {
		FileDownload file1 = new FileDownload("ftp://my.file.folder/file");
		Thread thread1 = new Thread(file1);
		thread1.start();
	}

}
