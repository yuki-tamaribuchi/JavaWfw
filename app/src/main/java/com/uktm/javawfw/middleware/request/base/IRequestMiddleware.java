package com.uktm.javawfw.middleware.request.base;

import com.uktm.javawfw.http.request.IRequest;


public interface IRequestMiddleware {
	public IRequest execute();
}
