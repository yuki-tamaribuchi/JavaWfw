package com.uktm.javawfw.server;

import java.io.IOException;
import java.net.*;

import com.uktm.javawfw.server.Worker;

public class Server {
	private String serverAddr;
	private int serverPort;
	private ServerSocket serverSocket;

	public Server(String serverAddr, int serverPort) {
		this.serverAddr = serverAddr;
		this.serverPort = serverPort;

	}
	
	public void serve() throws IOException {
		try {
			serverSocket = new ServerSocket();
			InetAddress inetAddress = InetAddress.getByName(serverAddr);
			SocketAddress socketAddress = new InetSocketAddress(inetAddress, serverPort);
			serverSocket.bind(socketAddress);

			while (true){
				Socket socket = serverSocket.accept();
				Worker worker = new Worker(socket);
				worker.run();
			}
		} finally {
			serverSocket.close();
		}
		
	}
}
