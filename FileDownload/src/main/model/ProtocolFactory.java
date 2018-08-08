package main.model;

import main.protocol.IProtocol;
import main.protocol.impl.FtpProtocolImpl;
import main.protocol.impl.HttpProtocolImpl;
import main.protocol.impl.HttpsProtocolImpl;
import main.protocol.impl.SftpProtocolImpl;
import main.utility.Protocols;

public class ProtocolFactory {

	public static IProtocol getProtocolImpl(Protocols protocol){
		switch(protocol){
		case HTTP :
			return new HttpProtocolImpl();
		case FTP:
			return new FtpProtocolImpl();
		case SFTP:
			return new SftpProtocolImpl();
		case HTTPS:
			return new HttpsProtocolImpl();
		default:
			return null;
			
		}
	}
	
}
