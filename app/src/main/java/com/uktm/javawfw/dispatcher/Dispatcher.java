package com.uktm.javawfw.dispatcher;

import com.uktm.javawfw.dispatcher.IDispatcher;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;

import java.lang.reflect.InvocationTargetException;

import com.uktm.javawfw.controller.base.IController;

public class Dispatcher implements IDispatcher {
	public static IResponse dispatch(IRequest request, Class<? extends IController> controllerClass){
		IResponse response = null;
		IController controller = null;

		try {
			controller = controllerClass.getDeclaredConstructor().newInstance();
			response = controller.get(request);
		} catch(InstantiationException|NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
			System.out.println("Dispatcher error: " + e);
		}

		return response;
	}
}
