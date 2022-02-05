package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;

import com.uktm.javawfw.http.response.AbstractResponse;


public class StatusResponse extends AbstractResponse {

	public StatusResponse(Socket socket, String status, Hashtable<String, String> responseOptions, String responseBody) {
		super(socket, status, responseOptions, responseBody);
	}
}