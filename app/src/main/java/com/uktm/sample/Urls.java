package com.uktm.sample;

import java.util.ArrayList;
import java.util.Hashtable;

import com.uktm.javawfw.urls.Path;
import com.uktm.javawfw.urls.AbstractUrls;

import com.uktm.sample.controllers.SampleController;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.middleware.request.security.AllowedHostMiddleware;


public class Urls extends AbstractUrls {
	public Urls() {
		ArrayList<Class<? extends IRequestMiddleware>> requestMiddlewares = new ArrayList<Class<? extends IRequestMiddleware>>();
		requestMiddlewares.add(AllowedHostMiddleware.class);
		urlPatterns.add(new Path("sample/", SampleController.class, "sample", requestMiddlewares, null));
		urlPatterns.add(new Path("sample2/<username>/", SampleController.class, "sample", requestMiddlewares, null));
		urlPatterns.add(new Path("sample3/<username>/entry/<id>/", SampleController.class, "sample", requestMiddlewares, null));
	}
}
