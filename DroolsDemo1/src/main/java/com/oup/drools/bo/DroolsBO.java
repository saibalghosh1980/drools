package com.oup.drools.bo;

public class DroolsBO {

	private RouteFacts facts = new RouteFacts();
	private String routeName;
	private String dummyParam="Y";

	public RouteFacts getFacts() {
		return facts;
	}

	public void setFacts(RouteFacts facts) {
		this.facts = facts;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDummyParam() {
		return dummyParam;
	}

	public void setDummyParam(String dummyParam) {
		this.dummyParam = dummyParam;
	}
	
	

}
