package com.uktm.javawfw.middleware.request.security;

import java.security.DrbgParameters.Reseed;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.middleware.request.base.AbstractRequestMiddleware;


public class AllowedHostMiddleware extends AbstractRequestMiddleware {
	public AllowedHostMiddleware(IRequest request) {
		super(request);
	}

	public IRequest execute() {
		System.out.println(request.getRequestLine());
		return request;
	}
}
