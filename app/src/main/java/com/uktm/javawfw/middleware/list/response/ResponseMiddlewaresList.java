package com.uktm.javawfw.middleware.list.response;

import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;
import com.uktm.javawfw.middleware.list.response.IResponseMiddlewaresList;

public class ResponseMiddlewaresList implements IResponseMiddlewaresList {
	private Class<? extends IResponseMiddleware>[] responseMiddlewaresList;
	public ResponseMiddlewaresList(Class<? extends IResponseMiddleware>... responseMiddlewaresList) {
		this.responseMiddlewaresList = responseMiddlewaresList;
	}

	public Class<? extends IResponseMiddleware>[] getResponseMiddlewaresList() {
		return responseMiddlewaresList;
	}
}
