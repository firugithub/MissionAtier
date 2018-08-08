import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

class NewTailCommand {
	public static void main(String args[]) {
		Map<Long, String> strmap = new HashMap<Long, String>();
		long numberOfLines = Long.valueOf(args[1]).longValue();
		try {
			/*
			 * Receive file name and no of lines to tail as command line
			 * argument
			 */
			RandomAccessFile randomFile = new RandomAccessFile(args[0], "r");

			long filelength = randomFile.length();
			long filepos = filelength - 1;
			long linescovered = 1;
			System.out.println(filepos);
			for (linescovered = 1; linescovered <= numberOfLines; filepos--) {
				randomFile.seek(filepos);
				if (randomFile.readByte() == 0xA)
					if (filepos == filelength - 1)
						continue;
					else {
						strmap.put(linescovered, randomFile.readLine());
						linescovered++;
					}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long startPosition = numberOfLines;
		while (startPosition != 0) {
			if (strmap.containsKey(startPosition)) {
				// System.out.println("HashMap contains "+ startPosition
				// +" as key");
				String outstr = (String) strmap.get(startPosition);
				System.out.println(outstr);
				startPosition--;

			}
		}
	}
}
