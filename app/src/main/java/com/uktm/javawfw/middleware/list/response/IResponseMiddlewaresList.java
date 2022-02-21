package com.uktm.javawfw.middleware.list.response;

import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;

public interface IResponseMiddlewaresList {
	public Class<? extends IResponseMiddleware>[] getResponseMiddlewaresList();
}
