package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;


import com.uktm.javawfw.http.response.AbstractResponse;


public class JsonResponse extends AbstractResponse {
	public JsonResponse(Socket socket, String status, Hashtable<String, String> responseOptions, String responseBody) {
		super(socket, status, responseOptions, responseBody);
		this.responseOptions.put("Content-Type", "application/json");
	}
}
