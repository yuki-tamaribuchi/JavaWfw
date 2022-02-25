package com.uktm.javawfw.middleware.request.security;

import java.security.DrbgParameters.Reseed;
import java.util.Hashtable;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.middleware.request.base.AbstractRequestMiddleware;


public class AllowedHostMiddleware extends AbstractRequestMiddleware {

	public static IRequest execute(IRequest request) {
		return request;
	}
}
