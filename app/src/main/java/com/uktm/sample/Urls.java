package com.uktm.sample;

import java.util.ArrayList;
import java.util.Hashtable;

import com.uktm.javawfw.urls.Path;
import com.uktm.javawfw.urls.AbstractUrls;

import com.uktm.sample.controllers.SampleController;


public class Urls extends AbstractUrls {
	public Urls() {
		urlPatterns.add(new Path("sample", SampleController.class, "sample"));
		urlPatterns.add(new Path("sample2/<uername>/", SampleController.class, "sample"));
		urlPatterns.add(new Path("sample3/<username>/entry/<id>/", SampleController.class, "sample"));
	}
}
