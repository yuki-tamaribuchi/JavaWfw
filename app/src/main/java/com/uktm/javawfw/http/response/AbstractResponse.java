package com.uktm.javawfw.http.response;

import java.net.Socket;
import java.util.Hashtable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


import com.uktm.javawfw.http.response.IResponse;


public abstract class AbstractResponse implements IResponse {
	protected Socket socket;
	protected String status;
	protected Hashtable<String, String> responseOptions;
	protected String responseBody;

	public AbstractResponse(Socket socket, String status, Hashtable<String, String> responseOptions, String responseBody) {
		this.socket = socket;
		this.status = status;
		
		if (responseOptions == null ) {
			this.responseOptions = new Hashtable<String, String>();
		} else {
			this.responseOptions = responseOptions;
		}
		if (responseBody == null) {
			responseBody = "";
		} else {
			this.responseBody = responseBody;
		}
		
	}

	private String createResponseLine() {
		return "HTTP/1.1 " + status + "\r\n";
	}

	private String createResponseHeader() {
		int contentLength;
		if (responseBody!=null){
			contentLength = responseBody.getBytes(StandardCharsets.UTF_8).length + 2;
		} else {
			contentLength = 0;
		}
		responseOptions.put("Content-Length", Integer.toString(contentLength));
		StringBuilder responseHeaderStringBuilder = new StringBuilder();
		responseOptions.forEach((optionName, optionValue) -> {
				responseHeaderStringBuilder.append(optionName + ": " + optionValue + "\r\n");
			});
		return responseHeaderStringBuilder.toString();
	}

	protected String createResponse() throws IOException {
		StringBuilder responseStringBuilder = new StringBuilder();
		responseStringBuilder.append(createResponseLine());
		responseStringBuilder.append(createResponseHeader());
		responseStringBuilder.append("\r\n");

		if (responseBody != null) {
			responseStringBuilder.append(responseBody);
			responseStringBuilder.append("\r\n");
		}

		return responseStringBuilder.toString();
	}

	public void sendResponse() throws IOException {
		String response = createResponse();

		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.write(response);
		out.flush();
	}
}
