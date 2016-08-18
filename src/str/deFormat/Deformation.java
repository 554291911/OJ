package str.deFormat;

import java.util.HashMap;
import java.util.Map.Entry;

public class Deformation {
	
	public boolean isDeformation(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return false;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < chars1.length; i++) {
			int count = 0;
			if (map.get(chars1[i]) != null)
				count = map.get(chars1[i]);
			map.put(chars1[i], count + 1);
		}
		for (int i = 0; i < chars2.length; i++) {
			int count = map.get(chars2[i]);
			map.put(chars2[i], --count);
			if (count == -1)
				return false;
		}
		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() > 0)
				return false;
		}
		return true;
	}
}
