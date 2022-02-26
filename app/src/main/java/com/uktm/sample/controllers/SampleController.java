package com.uktm.sample.controllers;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.http.response.JsonResponse;
import com.uktm.javawfw.controller.base.AbstractController;


public class SampleController extends AbstractController {
	public IResponse get(IRequest request) {
		String responseBody = request.getRequestLine().get("uri");


		return new JsonResponse(request.getSocket(), "200 OK", null, responseBody);
	}
}