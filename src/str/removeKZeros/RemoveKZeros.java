package str.removeKZeros;

public class RemoveKZeros {
	
	public String removeKZeros(String str, int k) {
		if (str == null || k < 1)
			return str;
		char[] chars = str.toCharArray();
		int count = 0;
		int start = -1;
		for (int i = 0; i != chars.length; i++) {
			if (chars[i] == '0') {
				count++;
				if (start == -1)
					start = i;
			} else {
				if (count == k) {
					while (count-- != 0)
						chars[start++] = 0;
				}
				count = 0;
				start = -1;
			}
		}
		if (count == k) {
			while (count-- != 0)
				chars[start++] = 0;
		}
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 0)
				result += chars[i];
		}
		return result;
	}
}
