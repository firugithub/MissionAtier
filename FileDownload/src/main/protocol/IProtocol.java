package main.protocol;

import java.io.IOException;
import java.net.MalformedURLException;

import main.model.FileDownload;

public interface IProtocol {

	public void download(String source, FileDownload fileParam) throws MalformedURLException,IOException;
}
