package com.uktm.javawfw.urls;

import java.util.regex.Pattern;
import java.util.ArrayList;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;

public interface IPath {
	public String getUrl();
	public Pattern getUrlPattern();
	public boolean isUrlMatched(String url);
	public Class<? extends IController> getController();
	public String getName();
	public ArrayList<Class<? extends IRequestMiddleware>> getRequestMiddlewares();
	public ArrayList<Class<? extends IResponseMiddleware>> getResponseMiddlewares();
}
