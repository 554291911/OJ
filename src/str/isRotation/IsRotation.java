package str.isRotation;

public class IsRotation {
	
	public boolean isRotation(String a, String b) {
		if (a == null || b == null || a.length() != b.length())
			return false;
		String b2 = b + b;
		a = ".*" + a + ".*";
		return b2.matches(a);
	}
}
