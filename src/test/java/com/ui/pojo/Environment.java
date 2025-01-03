package com.ui.pojo;

public class Environment {
	
	private String URL;
	private int MAX_NuMBER_OF_ATTEMPTS;

	public int getMAX_NuMBER_OF_ATTEMPTS() {
		return MAX_NuMBER_OF_ATTEMPTS;
	}

	public void setMAX_NuMBER_OF_ATTEMPTS(int mAX_NuMBER_OF_ATTEMPTS) {
		MAX_NuMBER_OF_ATTEMPTS = mAX_NuMBER_OF_ATTEMPTS;
	}

	public String getUrl() {
		return URL;
	}

	public void setUrl(String url) {
		this.URL = url;
	}

}
