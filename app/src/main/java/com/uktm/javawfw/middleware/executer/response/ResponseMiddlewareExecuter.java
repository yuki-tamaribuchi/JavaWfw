package com.uktm.javawfw.middleware.executer.response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.middleware.executer.response.IResponseMiddlewareExecuter;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;

public class ResponseMiddlewareExecuter implements IResponseMiddlewareExecuter {
	public static IResponse execute(Class<? extends IResponseMiddleware>[] middlewares, IResponse response) {
		if (middlewares != null) {
			for (Class<? extends IResponseMiddleware> middleware : middlewares) {
				try {
					Method execute = middleware.getMethod("execute", IResponse.class);
					Object instance = middleware.getDeclaredConstructor().newInstance();
					response = (IResponse)execute.invoke(instance, response);
				} catch (NoSuchMethodException e) {
					System.err.println(e);
				} catch (InstantiationException e) {
					System.err.println(e);
				} catch (IllegalAccessException e) {
					System.err.println(e);
				} catch (InvocationTargetException e) {
					System.err.println(e);
				}
			}
		}
		return response;
	}
}
