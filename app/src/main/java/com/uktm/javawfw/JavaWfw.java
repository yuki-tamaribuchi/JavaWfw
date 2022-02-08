package com.uktm.javawfw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uktm.javawfw.server.Server;
import com.uktm.javawfw.urls.IUrls;


public class JavaWfw {
    private ArrayList<IUrls> urlsArrayList = new ArrayList<IUrls>();
    private Server server;

    public void serve() {
        try{
            server = new Server("127.0.0.1", 8000, urlsArrayList);
            server.serve();
        } catch (IOException e) {
            System.err.println("Host error: " + e);
        }
    }

    public void addUrls(IUrls urls) {
        urlsArrayList.add(urls);
    }

    public ArrayList<IUrls> getUrlsArrayList() {
        return urlsArrayList;
    }
}
