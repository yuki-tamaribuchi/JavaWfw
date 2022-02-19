package com.uktm.javawfw.middleware.list.request;

import java.util.ArrayList;

import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;

public interface IRequestMiddlewaresList {
	public Class<? extends IRequestMiddleware>[] getRequestMiddlewares();
}