package com.uktm.javawfw.server;

import com.uktm.javawfw.http.request.Request;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.exception.http.request.LoadRequestFailedException;
import com.uktm.javawfw.http.response.IResponse;
import com.uktm.javawfw.http.response.URLNotFoundResponse;
import com.uktm.javawfw.urls.URLResolver;
import com.uktm.javawfw.exception.urls.URLMatchNotFoundException;
import com.uktm.javawfw.urls.IPath;
import com.uktm.javawfw.controller.base.IController;
import com.uktm.javawfw.urls.PathParameterResolver;


import java.net.Socket;
import java.util.Hashtable;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;


public class Worker extends Thread {
	private Socket socket;
	private IRequest request;
	private IResponse response;
	private URLResolver urlResolver;

	public Worker(Socket socket, URLResolver urlResolver){
		this.socket = socket;
		this.urlResolver = urlResolver;
	}

	public void run() {
		String url = null;
		IPath path = null;
		Class<? extends IController> controllerClass = null;
		IController controller = null;
		IResponse response = null;
		Hashtable<String, String> pathParameters;
		
		try{
			request = new Request(socket);
			System.out.println(request.getRequestOutput());
			url = request.getRequestLine().get("uri");

			try {
				path = urlResolver.resolve(url);
				pathParameters = PathParameterResolver.resolve(url, path);
				request.setPathParameters(pathParameters);
				controllerClass = path.getController();

				try {
					controller = controllerClass.getDeclaredConstructor().newInstance();
				} catch (Exception e) {
					System.out.println("New Instance error: " + e);
				}

				response = controller.get(request);

			} catch (URLMatchNotFoundException e) {
				response = new URLNotFoundResponse(socket);
			} finally {
				response.sendResponse();
				socket.close();
			}

		} catch (IOException e) {
			System.err.println("Host error: " + e);
		} catch (LoadRequestFailedException e) {
			System.out.println("Load request error: " + e);
		}
	}
}
