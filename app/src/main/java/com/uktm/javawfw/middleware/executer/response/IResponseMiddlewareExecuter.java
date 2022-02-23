package com.uktm.javawfw.middleware.executer.response;

import java.util.ArrayList;

import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;

public interface IResponseMiddlewareExecuter {
	public static IResponse execute(Class<? extends IResponseMiddleware>[] middlewares, IResponse response){return response;};
}
