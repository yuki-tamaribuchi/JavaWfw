package com.uktm.javawfw.http.request;

import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.exception.http.request.LoadRequestFailedException;


public class Request implements IRequest {
	protected Socket socket;
	protected Hashtable<String, String> requestLine = new Hashtable<String, String>();
	protected Hashtable<String, String> requestOptions = new Hashtable<String, String>();
	protected String requestBody;


	public Request(Socket socket) throws IOException, LoadRequestFailedException {
		this.socket = socket;
		if(!loadRequest(socket)) {
			throw new LoadRequestFailedException();
		}
	}
	

	private boolean loadRequest(Socket socket) throws IOException {
		StringBuilder requestHeaderStringBuilder = new StringBuilder();
		boolean isRequestLine = true;
		boolean headerFinished = false;
		int contentLength = -1;



		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


		while (!headerFinished) {
			String line = in.readLine();
			headerFinished = line.isEmpty();

			if (isRequestLine) {
				String[] splited_line = line.split(" ");
				requestLine.put("method", splited_line[0]);
				requestLine.put("uri", splited_line[1]);
				requestLine.put("protocol", splited_line[2]);
				
				isRequestLine = false;
			} else {
				String[] splitedLine = line.split(":");
				if (splitedLine.length == 2){
					requestOptions.put(splitedLine[0], splitedLine[1].substring(1));
				}
				
				if (line.startsWith("Content-Length:")) {
					String cl = line.substring("Content-Length:".length()).trim();
					contentLength = Integer.parseInt(cl);
				}
			}
		}



		char[] buf = new char[contentLength];
		in.read(buf);
		requestBody = new String(buf);

		return true;
	}

	public Socket getSocket() {
		return socket;
	}

	public Hashtable<String, String> getRequestLine() {
		return requestLine;
	}

	public Hashtable<String, String> getRequestOptions() {
		return requestOptions;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public String getRequestOutput() {
		LocalDateTime datetime = LocalDateTime.now();
		String formattedDatetime = datetime.format(DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss"));
		return formattedDatetime + " " + requestLine.get("method") + " " + requestLine.get("uri");
	}
}
