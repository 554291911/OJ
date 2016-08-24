package str.countChar;


public class CountChar {
	
	public String getCountStr(String str) {
		if (str == null || str.equals(""))
			return "";
		char[] chs = str.toCharArray();
		String res = String.valueOf(chs[0]);
		int num = 1;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] != chs[i - 1]) {
				res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
				num = 1;
			} else
				num++;
		}
		return concat(res, String.valueOf(num), "");
	}

	private String concat(String s1, String s2, String s3) {
		if (!s3.equals(""))
			s3 = "_" + s3;
		return s1 + "_" + s2 + s3;
	}
	
	public char getCharAt(String cstr, int index) {
		if (cstr == null || cstr.equals(""))
			return 0;
		String[] str = cstr.split("_");
		int sum = 0;
		for (int i = 1; i < str.length; i += 2) {
			sum += Integer.parseInt(str[i]);
			if (sum > index)
				return str[i - 1].charAt(0);
		}
		return 0;// char '0'代表什么都没有
	}
}
