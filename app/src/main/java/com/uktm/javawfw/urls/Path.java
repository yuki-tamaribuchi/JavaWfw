package com.uktm.javawfw.urls;

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

	public Class<? extends IController> getController() {
		return controller;
	}

	public String getName() {
		return name;
	}
}
