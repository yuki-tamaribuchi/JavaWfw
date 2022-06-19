package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;
import java.util.HashMap;
import org.json.JSONObject;


import com.uktm.javawfw.http.response.AbstractResponse;


public class JsonResponse extends AbstractResponse {
	public JsonResponse(Socket socket, String status, Hashtable<String, String> responseOptions, HashMap<String, String> jsonResponseBodyHashMap) {
		super(socket, status, responseOptions, null);
		this.responseOptions.put("Content-Type", "application/json");
		JSONObject jsonResponseBodyObject = new JSONObject(jsonResponseBodyHashMap);
		this.responseBody = jsonResponseBodyObject.toString();
	}
}
