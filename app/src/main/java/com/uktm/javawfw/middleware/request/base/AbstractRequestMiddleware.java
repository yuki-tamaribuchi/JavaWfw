package com.uktm.javawfw.middleware.request.base;


import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;
import com.uktm.javawfw.http.request.IRequest;


public abstract class AbstractRequestMiddleware implements IRequestMiddleware {
	protected IRequest request;

	public AbstractRequestMiddleware(IRequest request){
		this.request = request;
	}

	public abstract IRequest execute();
}