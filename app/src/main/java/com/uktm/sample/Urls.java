package com.uktm.sample;

import java.util.ArrayList;
import java.util.Hashtable;

import com.uktm.javawfw.urls.Path;
import com.uktm.javawfw.urls.AbstractUrls;

import com.uktm.sample.controllers.SampleController;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.middleware.request.security.AllowedHostMiddleware;

import com.uktm.javawfw.middleware.list.request.RequestMiddlewaresList;
import com.uktm.javawfw.middleware.list.response.ResponseMiddlewaresList;

import com.uktm.sample.middlewares.response.SampleResponseMiddleware;


public class Urls extends AbstractUrls {
	public Urls() {
		RequestMiddlewaresList requestMiddlewaresList = new RequestMiddlewaresList(AllowedHostMiddleware.class);
		ResponseMiddlewaresList responseMiddlewaresList = new ResponseMiddlewaresList(SampleResponseMiddleware.class);

		urlPatterns.add(new Path("sample/", SampleController.class, "sample", requestMiddlewaresList, responseMiddlewaresList));
		urlPatterns.add(new Path("sample2/<username>/", SampleController.class, "sample", requestMiddlewaresList, responseMiddlewaresList));
		urlPatterns.add(new Path("sample3/<username>/entry/<id>/", SampleController.class, "sample", requestMiddlewaresList, responseMiddlewaresList));
	}
}