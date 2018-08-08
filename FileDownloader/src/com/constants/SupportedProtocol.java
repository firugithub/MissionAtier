package com.constants;

public enum SupportedProtocol {

	HTTP, SFTP, SCP, HTTPS, FTP;
	public static String[] supportedProtocols() {
		SupportedProtocol[] supportedProtocols = values();
		String[] protocolArr = new String[supportedProtocols.length];

		for (int i = 0; i < supportedProtocols.length; i++) {
			protocolArr[i] = supportedProtocols[i].name();
		}

		return protocolArr;
	}

}