package com.uktm.javawfw.urls;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;
import com.uktm.javawfw.exception.urls.URLRegexNotMatchedException;

public class Path implements IPath {
	private String url;
	private Class<? extends IController> controller;
	private String name;
	private ArrayList<Class<? extends IRequestMiddleware>> requestMiddlewares;
	private ArrayList<Class<? extends IResponseMiddleware>> responseMiddlewares;

	public Path(String url, Class<? extends IController> controller, String name, ArrayList<Class<? extends IRequestMiddleware>> requestMiddlewares, ArrayList<Class<? extends IResponseMiddleware>> responseMiddlewares) {
		this.url = url;
		this.controller = controller;
		this.name = name;
		this.requestMiddlewares = requestMiddlewares;
		this.responseMiddlewares = responseMiddlewares;
	}

	public void validateUrl() throws URLRegexNotMatchedException {
		if (!url.matches("((([A-Za-z0-9\\-]+)|(\\<[A-Za-z0-9\\-]+\\>))\\/)+")) {
			throw new URLRegexNotMatchedException(url);
		}
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

	public ArrayList<Class<? extends IRequestMiddleware>> getRequestMiddlewares() {
		return requestMiddlewares;
	}

	public ArrayList<Class<? extends IResponseMiddleware>> getResponseMiddlewares() {
		return responseMiddlewares;
	}
}
