package com.uktm.javawfw.urls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.IPath;

public class Path implements IPath {
	private String url;
	private Class<? extends IController> controller;
	private String name;

	public Path(String url, Class<? extends IController> controller, String name) {
		this.url = url;
		this.controller = controller;
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public Pattern getUrlPattern() {
		String regexUrl = url.replaceAll("\\<(.*?)\\>", "[0-9a-zA-Z]+?");
		Pattern patternUrl = Pattern.compile(regexUrl);
		return patternUrl;
	}

	public boolean isUrlMatched(String url) {
		Pattern urlPattern = getUrlPattern();
		Matcher urlMatcher = urlPattern.matcher(url);
		return urlMatcher.matches();
	}

	public Class<? extends IController> getController() {
		return controller;
	}

	public String getName() {
		return name;
	}
}
