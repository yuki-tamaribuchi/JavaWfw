package com.uktm.javawfw.dispatcher;

import com.uktm.javawfw.dispatcher.IDispatcher;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.exception.http.response.NullResponseException;

import java.lang.reflect.InvocationTargetException;

import com.uktm.javawfw.controller.base.IController;

public class Dispatcher implements IDispatcher {
	public static IResponse dispatch(IRequest request, Class<? extends IController> controllerClass) throws NullResponseException {
		IResponse response = null;
		IController controller = null;

		try {
			controller = controllerClass.getDeclaredConstructor().newInstance();
			String requestMethod = request.getRequestLine().get("method");
			if (requestMethod.equals("GET")){
				response = controller.get(request);
			}
			else if (requestMethod.equals("POST")){
				response = controller.post(request);
			}
			else if (requestMethod.equals("PUT")){
				response = controller.put(request);
			}
			else if (requestMethod.equals("DELETE")){
				response = controller.delete(request);
			}

			if (response==null){
				throw new NullResponseException();
			}
		} catch(InstantiationException|NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
			System.out.println("Dispatcher error: " + e);
		}

		return response;
	}
}
