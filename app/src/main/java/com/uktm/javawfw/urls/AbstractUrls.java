package com.uktm.javawfw.urls;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.IUrls;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.urls.Path;
import com.uktm.javawfw.exception.urls.URLRegexNotMatchedException;

import java.util.ArrayList;


public abstract class AbstractUrls implements IUrls {
	public ArrayList<IPath> urlPatterns = new ArrayList<IPath>();

	public void validateUrls() throws URLRegexNotMatchedException {
		int i;
		for(i=0; i<=urlPatterns.size()-1; i++) {
			urlPatterns.get(i).validateUrl();
		}
	}

	private IPath matchUrl(String url) {
		int i;
		for(i=0; i<=urlPatterns.size()-1; i++) {
			if (urlPatterns.get(i).isUrlMatched(url)) {
				return urlPatterns.get(i);
			}
		}
		return null;
	}

	public IPath getPath(String url) {
		return matchUrl(url);
	}
}