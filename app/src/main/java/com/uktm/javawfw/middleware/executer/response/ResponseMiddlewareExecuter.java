package com.uktm.javawfw.middleware.executer.response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.middleware.executer.response.IResponseMiddlewareExecuter;
import com.uktm.javawfw.middleware.response.base.IResponseMiddleware;

public class ResponseMiddlewareExecuter implements IResponseMiddlewareExecuter {
	public static IResponse execute(ArrayList<Class<? extends IResponseMiddleware>> middlewares, IResponse response) {
		if (middlewares != null) {
			int i;

			for (i=0; i<=middlewares.size()-1; i++) {
				try {
					Method execute = middlewares.get(i).getMethod("execute", IResponse.class);
					Object instance = middlewares.get(i).getDeclaredConstructor().newInstance();
					response = (IResponse)execute.invoke(instance, response);
				} catch (NoSuchMethodException e){
					System.out.println(e);
				} catch(InstantiationException e) {
					System.out.println(e);
				}catch (IllegalAccessException e) {
					System.out.println(e);
				} catch (InvocationTargetException e){
					System.out.println(e);
				}
			}
		}
		return response;
	}
}
