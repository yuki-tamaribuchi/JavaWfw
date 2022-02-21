package com.uktm.javawfw.middleware.request.base;

import com.uktm.javawfw.http.request.IRequest;


public interface IRequestMiddleware {
	public static IRequest execute(IRequest request){return request;};
}
