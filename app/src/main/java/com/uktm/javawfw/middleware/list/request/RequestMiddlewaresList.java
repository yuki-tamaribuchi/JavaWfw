package com.uktm.javawfw.middleware.list.request;

import java.util.ArrayList;

import com.uktm.javawfw.middleware.list.request.IRequestMiddlewaresList;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;

public class RequestMiddlewaresList implements IRequestMiddlewaresList {
	private Class<? extends IRequestMiddleware>[] requestMiddlewares;

	public RequestMiddlewaresList(Class<? extends IRequestMiddleware>... requestMiddlewares) {
		this.requestMiddlewares = requestMiddlewares;
	}

	public Class<? extends IRequestMiddleware>[] getRequestMiddlewares(){
		return requestMiddlewares;
	}
}