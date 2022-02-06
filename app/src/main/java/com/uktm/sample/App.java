package com.uktm.sample;

import com.uktm.javawfw.JavaWfw;
import com.uktm.javawfw.urls.IUrls;


import com.uktm.sample.Urls;

public class App {
	public static void main(String[] args) {
        IUrls urls = new Urls();

        JavaWfw app = new JavaWfw();
        app.addUrls(urls);

        app.serve();
    }
}