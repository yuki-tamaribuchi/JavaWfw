package com.uktm.javawfw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uktm.javawfw.server.Server;
import com.uktm.javawfw.urls.IUrls;
import com.uktm.javawfw.exception.urls.URLRegexNotMatchedException;


public class JavaWfw {
    private String serverAddr;
    private int serverPort;
    private ArrayList<IUrls> urlsArrayList = new ArrayList<IUrls>();
    private Server server;

    public JavaWfw(String serverAddr, int serverPort) {
        this.serverAddr = serverAddr;
        this.serverPort = serverPort;
    }

    public void serve() {
        try{
            server = new Server(serverAddr, serverPort, urlsArrayList);
            server.serve();
        } catch (IOException e) {
            System.err.println("Host error: " + e);
        }
    }

    public void addUrls(IUrls urls) {
        try {
            urls.validateUrls();
        } catch (URLRegexNotMatchedException e) {
            System.exit(0);
        }
        urlsArrayList.add(urls);
    }

    public ArrayList<IUrls> getUrlsArrayList() {
        return urlsArrayList;
    }
}
