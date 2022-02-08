package com.uktm.javawfw.dispatcher;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.controller.base.IController;

public interface IDispatcher {
	public static IResponse dispatch(IRequest request, Class<? extends IController> controllerClass){return null;};
}
