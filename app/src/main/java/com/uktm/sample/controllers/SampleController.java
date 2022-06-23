package com.uktm.sample.controllers;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.http.response.JsonResponse;
import com.uktm.javawfw.controller.base.AbstractController;
import com.uktm.javawfw.http.response.HttpStatus;

import java.util.HashMap;

public class SampleController extends AbstractController {
	public IResponse get(IRequest request) {
		String message = request.getRequestLine().get("uri") + "が呼ばれました。";

		HashMap<String, String> jsonResponseBodyHashMap = new HashMap<>();
		jsonResponseBodyHashMap.put("message", message);

		return new JsonResponse(request.getSocket(), HttpStatus.OK, null, jsonResponseBodyHashMap);
	}
}