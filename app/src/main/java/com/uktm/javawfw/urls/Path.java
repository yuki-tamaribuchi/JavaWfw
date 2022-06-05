package com.uktm.javawfw.urls;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;
import com.uktm.javawfw.exception.urls.URLRegexNotMatchedException;
import com.uktm.javawfw.middleware.list.request.IRequestMiddlewaresList;
import com.uktm.javawfw.middleware.list.response.IResponseMiddlewaresList;

public class Path implements IPath {
	private String url;
	private Class<? extends IController> controller;
	private String name;
	private Class<? extends IRequestMiddleware>[] requestMiddlewares;
	private Class<? extends IResponseMiddleware>[] responseMiddlewares;
	private Pattern urlPattern;

	public Path(String url, Class<? extends IController> controller, String name, IRequestMiddlewaresList requestMiddlewaresList, IResponseMiddlewaresList responseMiddlewaresList) {
		this.url = url;
		this.controller = controller;
		this.name = name;
		this.requestMiddlewares = requestMiddlewaresList.getRequestMiddlewares();
		this.responseMiddlewares = responseMiddlewaresList.getResponseMiddlewaresList();
		this.urlPattern = getUrlPattern();
	}

	public void validateUrl() throws URLRegexNotMatchedException {
		if (!url.matches("((([A-Za-z0-9\\-]+)|(\\<[A-Za-z0-9\\-]+\\>))\\/)+")) {
			throw new URLRegexNotMatchedException(url);
		}
	}

	public String getUrl() {
		return url;
	}

	private Pattern getUrlPattern() {
		String regexUrl = url.replaceAll("\\<(.*?)\\>", "[0-9a-zA-Z]+?");
		Pattern patternUrl = Pattern.compile(regexUrl);
		return patternUrl;
	}

	public boolean isUrlMatched(String url) {
		Pattern urlPattern = getUrlPattern();
		Matcher urlMatcher = urlPattern.matcher(url);
		Matcher urlMatcher = this.urlPattern.matcher(url);
		return urlMatcher.matches();
	}

	public Class<? extends IController> getController() {
		return controller;
	}

	public String getName() {
		return name;
	}

	public Class<? extends IRequestMiddleware>[] getRequestMiddlewares() {
		return requestMiddlewares;
	}

	public Class<? extends IResponseMiddleware>[] getResponseMiddlewares() {
		return responseMiddlewares;
	}
}
