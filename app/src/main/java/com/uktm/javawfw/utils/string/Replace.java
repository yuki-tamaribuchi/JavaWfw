package com.uktm.javawfw.utils.string;

public class Replace {
	//https://www.fenet.jp/java/column/java_beginner/5974/
	public static String replaceLast(String string, String regex, String replacement) {
		if(string == null || string.isEmpty()){
		    return string;
	    }

		return string.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
	}
}
