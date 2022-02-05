package com.uktm.javawfw.controller.base;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;

public interface IController {
	public IResponse get(IRequest request);
	public IResponse post(IRequest request);
	public IResponse put(IRequest request);
	public IResponse delete(IRequest request);
}
