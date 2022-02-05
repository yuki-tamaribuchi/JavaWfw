package com.uktm.sample.controllers;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.http.response.JsonResponse;

import java.util.Hashtable;

import com.uktm.javawfw.controller.base.AbstractController;


public class SampleController extends AbstractController {
	public IResponse get(IRequest request) {
		
		return new JsonResponse(request.getSocket(), "200 OK", null, "");
	}
}
