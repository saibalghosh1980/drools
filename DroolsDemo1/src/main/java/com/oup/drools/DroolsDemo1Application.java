package com.oup.drools;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oup.drools.bo.DroolsBO;
import com.oup.drools.bo.RouteFacts;
import com.oup.drools.service.RouteFinderService;

@SpringBootApplication
public class DroolsDemo1Application implements CommandLineRunner {
	
	@Autowired
	@Qualifier("springManagedRouteFinderService")
	RouteFinderService routeFinderSvc;

	public static void main(String[] args) {
		SpringApplication.run(DroolsDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		DroolsBO droolsBO=new DroolsBO();
		RouteFacts routeFacts=new RouteFacts();
		routeFacts.setFact1("1");
		routeFacts.setFact2("A");
		droolsBO.setFacts(routeFacts);
		routeFinderSvc.findRoute(droolsBO);
		
	}

}

