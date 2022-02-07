package com.uktm.javawfw.urls;

import java.util.regex.Pattern;

import com.uktm.javawfw.controller.base.IController;

public interface IPath {
	public String getUrl();
	public Pattern getUrlPattern();
	public boolean isUrlMatched(String url);
	public Class<? extends IController> getController();
	public String getName();
}
