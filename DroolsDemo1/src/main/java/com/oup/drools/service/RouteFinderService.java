package com.oup.drools.service;

import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.javaparser.ast.expr.ThisExpr;
import com.oup.drools.bo.DroolsBO;
import com.oup.drools.bo.RouteFacts;
import com.oup.drools.listener.TrackingAgendaEventListener;

@Service("springManagedRouteFinderService")
public class RouteFinderService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("springManagedKieContainer")
    private KieContainer kContainer;

	/*
	 * public String findRoute(DroolsBO droolsBO) { KieSession kieSession =
	 * kContainer.newKieSession(); //kieSession.setGlobal("rideFare", rideFare);
	 * kieSession.insert(((RouteFacts)droolsBO.getFacts().get(0)));
	 * kieSession.fireAllRules(); kieSession.dispose();
	 * System.out.println("!! THE ROUTE NAME IS !! " +
	 * ((RouteFacts)droolsBO.getFacts().get(0)).getRouteName()); return
	 * ((RouteFacts)droolsBO.getFacts().get(0)).getRouteName(); }
	 */
    
	public String findRoute(DroolsBO droolsBO) {
        KieSession kieSession = kContainer.newKieSession();
        TrackingAgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
        //kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(droolsBO);
        kieSession.fireAllRules();
        logger.info(agendaEventListener.matchsToString());
        //List<Activation> activations = agendaEventListener.getActivationList();
        kieSession.dispose();        
        System.out.println("!! THE ROUTE NAME IS !! " + droolsBO.getRouteName());
        return droolsBO.getRouteName();
    }

}
