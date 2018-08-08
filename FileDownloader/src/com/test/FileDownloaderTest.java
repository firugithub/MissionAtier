package com.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.constants.Constants;
import com.main.Downloader;
import com.model.DownloadInfo;
import com.util.FileUtilities;

public class FileDownloaderTest {

	@Test
	public void testIsValidUrl() throws URISyntaxException

	{
		Assert.assertTrue(FileUtilities.isValidURL(new URI("http://my.file.com/file")));
		Assert.assertTrue(FileUtilities.isValidURL(new URI("ftp://other.file.com/other")));
		Assert.assertTrue(FileUtilities.isValidURL(new URI("sftp://and.also.this/ending")));
		Assert.assertFalse(FileUtilities.isValidURL(new URI("ftp://asdas.test.txt")));
		Assert.assertTrue(FileUtilities.isValidURL(
				new URI("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING")));
		Assert.assertTrue(FileUtilities.isValidURL(new URI("ftp://localhost/Desktop/settings.xml")));
		Assert.assertTrue(FileUtilities.isValidURL(new URI("http://norvig.com/big.txt")));
		Assert.assertFalse(FileUtilities.isValidURL(new URI("ftp://settings.xml")));
	}

	@Test
	public void testGenerateFileName() {
		String generatedFileName = FileUtilities.generateFileName("ftp", "/a.txt",
				new DownloadInfo("/localhost/a.txt", "dummypath"));
		Assert.assertTrue(generatedFileName.substring(generatedFileName.indexOf(".")).length() > 0);
		String generatedFileNameWithoutInitialExtension = FileUtilities.generateFileName("ftp", "/a",
				new DownloadInfo("/localhost/a", "dummypath"));
		Assert.assertTrue(generatedFileNameWithoutInitialExtension
				.substring(generatedFileNameWithoutInitialExtension.indexOf(".")).length() > 0);
	}

	@Test
	public void testFileDownload() throws InterruptedException {
		Downloader downloader = new Downloader("ftp://localhost/Desktop/settings.xml",
				Constants.DEFAULT_FILE_DOWNLOAD_LOCATION, "userName", "Password");
		Thread thread1 = new Thread(downloader);
		thread1.start();
		Thread.sleep(5000);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testParseErrorScenario1() throws URISyntaxException {
		FileUtilities.parse(null);
	}
}
