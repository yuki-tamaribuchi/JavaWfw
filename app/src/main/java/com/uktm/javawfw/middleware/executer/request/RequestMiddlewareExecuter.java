package com.uktm.javawfw.middleware.executer.request;

import java.util.ArrayList;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;


public class RequestMiddlewareExecuter {
	private IRequest request;
	private ArrayList<IRequestMiddleware> middlewares;
	
	
	public RequestMiddlewareExecuter(IRequest request, ArrayList<IRequestMiddleware> middlewares) {
		this.request = request;
		this.middlewares = middlewares;
	}

	public IRequest execute() {
		for (IRequestMiddleware middleware : middlewares) {

			request = middleware.execute();
		}
		return request;
	}
}
