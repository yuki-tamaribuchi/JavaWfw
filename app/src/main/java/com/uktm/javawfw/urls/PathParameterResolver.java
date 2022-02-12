package com.uktm.javawfw.urls;

import java.util.Hashtable;
import java.util.regex.Pattern;

import com.uktm.javawfw.urls.IPath;

public class PathParameterResolver {
	public static Hashtable<String, String> resolve(String url, IPath path) {
		Hashtable<String, String> pathParameters = new Hashtable<String, String>();
		String pathParameterName;


		String pathUrl = path.getUrl();
		String[] splitedPathUrl = pathUrl.split("/");
		String[] splitedUrl = url.split("/");

		if ( splitedPathUrl.length == splitedUrl.length) {
			int i;
			for (i=0; i<=splitedPathUrl.length-1; i++) {
				if (splitedPathUrl[i].startsWith("<") && splitedPathUrl[i].endsWith(">")) {
					pathParameterName = splitedPathUrl[i].substring(1, splitedPathUrl[i].length()-1);
					pathParameters.put(pathParameterName, splitedUrl[i]);
				}
			}
		}

		return pathParameters;
	}
}
