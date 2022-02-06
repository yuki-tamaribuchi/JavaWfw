package com.uktm.javawfw.server;

import java.io.IOException;
import java.net.*;

import com.uktm.javawfw.server.Worker;
import com.uktm.javawfw.JavaWfw;
import com.uktm.javawfw.urls.URLResolver;

public class Server {
	private String serverAddr;
	private int serverPort;
	private ServerSocket serverSocket;
	private URLResolver urlResolver;

	public Server(String serverAddr, int serverPort, JavaWfw app) {
		this.serverAddr = serverAddr;
		this.serverPort = serverPort;
		this.urlResolver = URLResolver.getInstance(app.getUrlsArrayList());
	}
	
	public void serve() throws IOException {
		try {
			serverSocket = new ServerSocket();
			InetAddress inetAddress = InetAddress.getByName(serverAddr);
			SocketAddress socketAddress = new InetSocketAddress(inetAddress, serverPort);
			serverSocket.bind(socketAddress);

			while (true){
				Socket socket = serverSocket.accept();
				Worker worker = new Worker(socket, urlResolver);
				worker.run();
			}
		} finally {
			serverSocket.close();
		}
		
	}
}
