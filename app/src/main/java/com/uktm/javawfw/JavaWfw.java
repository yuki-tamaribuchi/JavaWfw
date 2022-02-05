package com.uktm.javawfw;

import java.io.IOException;

import com.uktm.javawfw.server.Server;


public class JavaWfw {
	public JavaWfw() {
		try{
            Server server = new Server("127.0.0.1", 8000);
            server.serve();
        } catch (IOException e) {
            System.err.println("Host error: " + e);
        }
	}
	
}
