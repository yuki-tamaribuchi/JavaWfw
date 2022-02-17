package com.uktm.javawfw.middleware.response.base;

import com.uktm.javawfw.http.response.IResponse;

public interface IResponseMiddleware {
	public static IResponse execute(IResponse response){return response;};
}
