package com.uktm.javawfw.server;

import com.uktm.javawfw.http.request.Request;
import com.uktm.javawfw.http.request.IRequest;
import com.uktm.javawfw.exception.http.request.LoadRequestFailedException;
import com.uktm.javawfw.http.response.IResponse;

import com.uktm.sample.controllers.SampleController;
import com.uktm.javawfw.controller.base.IController;


import java.net.*;
import java.util.Hashtable;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;


public class Worker extends Thread {
	private Socket socket;
	private IRequest request;
	private IResponse response;


	public Worker(Socket socket){
		this.socket = socket;
	}


	public void run() {
		try{
			request = new Request(socket);
			System.out.println(request.getRequestOutput());


			IController contorller = new SampleController();
			IResponse response = contorller.get(request);
			response.sendResponse();

			socket.close();

		} catch (IOException e) {
			System.err.println("Host error: " + e);
		} catch (LoadRequestFailedException e) {
			System.out.println("Load request error: " + e);
		}
	}
}
