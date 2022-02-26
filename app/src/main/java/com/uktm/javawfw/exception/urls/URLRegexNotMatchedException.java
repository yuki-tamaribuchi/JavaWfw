package com.uktm.javawfw.exception.urls;

public class URLRegexNotMatchedException extends Exception {
	public URLRegexNotMatchedException(String url) {
		System.err.println("URL regex error: " + url);
		if (url.startsWith("/")) {
			System.err.println("Please delete first \"/\" from the url");
		}
		if (!url.endsWith("/")) {
			System.err.println("Please add \"/\" to the end of the url.");
		}
		for (String urlToken : url.split("/")) {
			if (urlToken.startsWith("<") && !urlToken.endsWith(">")) {
				if (urlToken.contains(">")) {
					System.err.println("Please use \">\" only at the end of path parameter holder" + urlToken);
				} else {
					System.err.println("Please add \">\" to the end of path parameter holder : " + urlToken);
				}
			}
			if (!urlToken.startsWith("<") && urlToken.endsWith(">")) {
				if (urlToken.contains("<")) {
					System.err.println("Please use \"<\" only at the first of path parameter :" + urlToken);
				} else {
					System.err.println("Please add \"<\" to the first of path parameter holder : " + urlToken);
				}
			}
		}
	}
}
