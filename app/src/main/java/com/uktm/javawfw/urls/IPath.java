package com.uktm.javawfw.urls;

import com.uktm.javawfw.controller.base.IController;

public interface IPath {
	public String getUrl();
	public Class<? extends IController> getController();
	public String getName();
}
