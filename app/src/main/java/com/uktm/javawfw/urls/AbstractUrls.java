package com.uktm.javawfw.urls;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.IUrls;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.urls.Path;

import java.util.ArrayList;


public abstract class AbstractUrls implements IUrls {
	public ArrayList<Path> urlPatterns = new ArrayList<Path>();
	
	private ArrayList<String> getUrls() {
		ArrayList<String> urlList = new ArrayList<String>();
		for(Path path : urlPatterns){
			urlList.add(path.getUrl());
		}
		return urlList;
	}

	private int matchUrl(String url) {
		ArrayList<String> urls = getUrls();
		int idx = urls.indexOf(url);
		return idx;
	}

	public IPath getPath(String url) {
		int matchedIdx;
		if ((matchedIdx=matchUrl(url)) == -1){
			return null;
		} else {
			return urlPatterns.get(matchedIdx);
		}
	}
}