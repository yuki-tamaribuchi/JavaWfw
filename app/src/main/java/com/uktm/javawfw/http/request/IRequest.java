package com.uktm.javawfw.http.request;

import java.net.Socket;
import java.util.Hashtable;


public interface IRequest {
	public Socket getSocket();
	public Hashtable<String, String> getRequestLine();
	public Hashtable<String, String> getRequestOptions();
	public String getRequestBody();
	public String getRequestOutput();
	public void setPathParameters(Hashtable<String, String> pathParameters);
	public Hashtable<String, String> getPathParameters();
	public Hashtable<String, String> getQueryParameters();
}
