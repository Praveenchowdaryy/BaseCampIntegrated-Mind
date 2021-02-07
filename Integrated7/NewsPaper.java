package com.mind.Integrated7;

public class NewsPaper {
	private String name;
	private String language;
	private int subscriberCount;

	public NewsPaper(String name, String language) {
		this.name = name;
		this.language = language;
	}

	public int getSubscriberCount() {
		return subscriberCount;
	}

	public void setSubscriberCount(int subscriberCount) {
		this.subscriberCount = subscriberCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
