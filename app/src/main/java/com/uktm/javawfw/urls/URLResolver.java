package com.uktm.javawfw.urls;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.uktm.javawfw.urls.IUrls;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.exception.urls.URLMatchNotFoundException;


public class URLResolver {
	static URLResolver instance;
	private ArrayList<IUrls> urlsArrayList;

	private URLResolver(ArrayList<IUrls> urlsArrayList) {
		this.urlsArrayList = urlsArrayList;
	}

	public static URLResolver getInstance(ArrayList<IUrls> urlsArrayList) {
		if (instance == null) {
			instance = new URLResolver(urlsArrayList);
			return instance;
		} else {
			return instance;
		}
	}

	public IPath resolve(String url) throws URLMatchNotFoundException {
		int i;
		for (i=0; i<=urlsArrayList.size()-1; i++) {
			IPath path = urlsArrayList.get(i).getPath(url);
			if (path != null) {
				return path;
			}
		}
		throw new URLMatchNotFoundException();
	}
	
}
