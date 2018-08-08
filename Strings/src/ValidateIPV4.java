
/* package whatever; // don't place package name! */

/* Name of the class has to be "Main" only if the class is public. */
public class ValidateIPV4 {
	static boolean validateIp(String input) {
		String[] arr = input.split("\\.");
		if (arr.length != 4)
			return false;
		for (String str : arr) {
			if (!str.matches("\\d+"))
				return false;
			else if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255)
				return false;
		}
		return true;
	}

	static boolean validateIpRegex(String input) {
		String ipv4pattern = "\\b(?:(?:[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}"
				+ "(?:[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";
		return input.matches(ipv4pattern);
	}

	public static void main(String[] args) {
		System.out.println(validateIpRegex("192.255.1.1"));
	}
}