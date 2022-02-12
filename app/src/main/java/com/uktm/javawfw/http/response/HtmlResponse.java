package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;

import com.uktm.javawfw.http.response.AbstractResponse;


public class HtmlResponse extends AbstractResponse {
	public HtmlResponse(Socket socket, String status, Hashtable<String, String> responseOptions, String responseBody) {
		super(socket, status, responseOptions, responseBody);
		this.responseOptions.put("Content-Type", "text/html");
	}
}
