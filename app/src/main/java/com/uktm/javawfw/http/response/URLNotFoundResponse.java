package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;

import com.uktm.javawfw.http.response.AbstractResponse;


public class URLNotFoundResponse extends AbstractResponse {
	public URLNotFoundResponse(Socket socket) {
		super(socket, "404 Not Found", null, null);
	}
}
