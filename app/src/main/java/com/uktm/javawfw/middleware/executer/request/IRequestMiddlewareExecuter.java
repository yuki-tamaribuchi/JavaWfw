package com.uktm.javawfw.middleware.executer.request;

import java.util.ArrayList;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;

public interface IRequestMiddlewareExecuter {
	public static IRequest execute(ArrayList<Class<? extends IRequestMiddleware>> middlewares, IRequest request){return request;};
}