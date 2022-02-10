package com.uktm.javawfw.urls;

import java.util.ArrayList;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.Path;
import com.uktm.javawfw.exception.urls.URLRegexNotMatchedException;


public interface IUrls {
	public void validateUrls() throws URLRegexNotMatchedException;
	public IPath getPath(String url);
}
