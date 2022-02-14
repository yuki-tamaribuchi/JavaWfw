package com.uktm.javawfw.middleware.executer.request;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import com.uktm.javawfw.middleware.executer.request.IRequestMiddlewareExecuter;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.request.Request;
import com.uktm.javawfw.middleware.request.base.IRequestMiddleware;



public class RequestMiddlewareExecuter implements IRequestMiddlewareExecuter {
	public static IRequest execute(ArrayList<Class<? extends IRequestMiddleware>> middlewares, IRequest request) {
		if (middlewares != null) {
			int i;

			for (i=0; i<=middlewares.size()-1; i++){
				try {
					Method execute = middlewares.get(i).getMethod("execute", IRequest.class);
					Object instance = middlewares.get(i).getDeclaredConstructor().newInstance();
					request = (IRequest)execute.invoke(instance, request);
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
		return request;
	}
}
