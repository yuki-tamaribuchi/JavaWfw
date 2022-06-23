package com.uktm.javawfw.http.response;

import java.net.Socket;

import com.uktm.javawfw.http.response.AbstractResponse;
import com.uktm.javawfw.http.response.HttpStatus;

public class InternalServerErrorResponse extends AbstractResponse {
	public InternalServerErrorResponse(Socket socket) {
		super(socket, HttpStatus.INTERNAL_SERVER_ERROR, null, null);
	}
}
