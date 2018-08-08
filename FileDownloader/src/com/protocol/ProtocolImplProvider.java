package com.protocol;

/*
 * This class is a factory class to provide concrete implementation for 
 * protocols to be used to read files from given url's.
 */
import com.constants.SupportedProtocol;
import com.protocol.impl.FtpProtocol;
import com.protocol.impl.HttpProtocol;
import com.protocol.impl.HttpsProtocol;
import com.protocol.impl.ScpProtocol;
import com.protocol.impl.SftpProtocol;

public class ProtocolImplProvider {
	public static IProtocol getProtocolImpl(SupportedProtocol protocol) {
		switch (protocol) {
		case FTP:
			return new FtpProtocol();
		case HTTP:
			return new HttpProtocol();
		case HTTPS:
			return new HttpsProtocol();
		case SCP:
			return new ScpProtocol();
		case SFTP:
			return new SftpProtocol();
		default:
			return null;

		}
	}
}
