package com.barclays.chat.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationListenerBean implements ApplicationListener<ApplicationEvent>{
	
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(" AllApplicationEventListener (with hashcode) "
                + this.hashCode() + "\n received "
                + applicationEvent.getClass() + "\n at "
                /*+ formatDate(applicationEvent.getTimestamp())*/
                + "\n with Source as "
                + applicationEvent.getSource().getClass());
    }
	
	public void serviceEngine(String serviceUrl){
		if(serviceUrl.contains("textReply")){
			
		}
	}

}
