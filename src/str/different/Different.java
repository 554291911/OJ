package str.different;

public class Different {
	public boolean checkDifferent(String iniString) {
		return !iniString.matches(".*(.).*(\\1).*");
	}
}