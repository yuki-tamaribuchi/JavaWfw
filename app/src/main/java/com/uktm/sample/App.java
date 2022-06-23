package com.uktm.sample;

import com.uktm.javawfw.JavaWfw;
import com.uktm.javawfw.urls.IUrls;


import com.uktm.sample.Urls;

public class App {
	public static void main(String[] args) {
        String serverAddr = "127.0.0.1";
        int serverPort = 8000;
        IUrls urls = new Urls();

        JavaWfw app = new JavaWfw(serverAddr, serverPort);
        app.addUrls(urls);

        app.serve();
    }
}