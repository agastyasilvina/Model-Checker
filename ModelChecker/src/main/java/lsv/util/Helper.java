package lsv.util;

import java.util.Arrays;

public class Helper {
	public static boolean containAnd(String [] s1, String [] s2) {
		boolean result = true;
		for(int i = 0; i < s2.length; i++) {
			if(!Arrays.asList(s1).contains(s2[i])) {
				result = false;
				break;
			}
		}
		return result;
	}
}
