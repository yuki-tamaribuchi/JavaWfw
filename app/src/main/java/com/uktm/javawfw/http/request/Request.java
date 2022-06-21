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
	private Socket socket;
	private Hashtable<String, String> requestLine = new Hashtable<String, String>();
	private Hashtable<String, String> requestOptions = new Hashtable<String, String>();
	private String requestBody;
	private Hashtable<String, String> pathParameters;
	private Hashtable<String, String> queryParameters = new Hashtable<>();


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
				String method = splited_line[0];
				String uri = splited_line[1].substring(1);
				String protocol = splited_line[2];
				rawUri = uri;

				if (uri.contains("?")) {
					String[] splittedUri = uri.split("\\?");
					uri = splittedUri[0];
					createQureyParameterHashTable(splittedUri[1]);
				}

				requestLine.put("method", method);
				requestLine.put("uri", uri);
				requestLine.put("protocol", protocol);
				
				isRequestLine = false;
			} else {
				String[] splitedLine = line.split(": ");
				if (splitedLine.length == 2){
					requestOptions.put(splitedLine[0], splitedLine[1]);
				}
				
				if (line.startsWith("Content-Length:")) {
					String cl = line.substring("Content-Length:".length()).trim();
					contentLength = Integer.parseInt(cl);
				}
			}
		}

		if (contentLength != -1) {
			char[] buf = new char[contentLength];
			in.read(buf);
			requestBody = new String(buf);
		}
		
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

	public void setPathParameters(Hashtable<String, String> pathParameters) {
		this.pathParameters = pathParameters;
	}

	public Hashtable<String, String> getPathParameters() {
		return pathParameters;
	}

	private void createQureyParameterHashTable(String queryParametersString) {
		String[] splittedQueryParametersString = queryParametersString.split("&");
		for (String queryParameter : splittedQueryParametersString) {
			String splittedQueryParameter[] = queryParameter.split("=");
			queryParameters.put(splittedQueryParameter[0], splittedQueryParameter[1]);
		}
	}

	public Hashtable<String, String> getQueryParameters() {
		return queryParameters;
	}

	public String getQueryParameterByKey(String key) {
		if (queryParameters.containsKey(key)){
			return queryParameters.get(key);
		}
		return null;
	}
}
