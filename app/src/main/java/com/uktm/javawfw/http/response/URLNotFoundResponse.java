package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;

import com.uktm.javawfw.http.response.AbstractResponse;
import com.uktm.javawfw.http.response.HttpStatus;


public class URLNotFoundResponse extends AbstractResponse {
	public URLNotFoundResponse(Socket socket) {
		super(socket, HttpStatus.NOT_FOUND, null, null);
	}
}
