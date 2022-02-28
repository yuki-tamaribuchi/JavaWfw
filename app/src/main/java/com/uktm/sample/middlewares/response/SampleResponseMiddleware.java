package com.uktm.sample.middlewares.response;

import com.uktm.javawfw.middleware.response.base.AbstractResponseMiddleware;
import com.uktm.javawfw.http.response.IResponse;

public class SampleResponseMiddleware extends AbstractResponseMiddleware {
	public static IResponse execute(IResponse response) {
		System.out.println(response);
		return response;
	}
}
