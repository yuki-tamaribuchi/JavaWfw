package com.uktm.javawfw.controller.base;

import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;

import com.uktm.javawfw.http.response.StatusResponse;

public abstract class AbstractController implements IController {
	public IResponse get(IRequest request) {
		return new StatusResponse(request.getSocket(), "405 Not Implemented", null, null);
	}

	public IResponse post(IRequest request) {
		return new StatusResponse(request.getSocket(), "405 Not Implemented", null, null);
	}

	public IResponse put(IRequest request) {
		return new StatusResponse(request.getSocket(), "405 Not Implemented", null, null);
	}

	public IResponse delete(IRequest request) {
		return new StatusResponse(request.getSocket(), "405 Not Implemented", null, null);
	}
}