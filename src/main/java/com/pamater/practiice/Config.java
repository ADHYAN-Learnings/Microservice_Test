package com.pamater.practiice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config extends ResourceConfig {
	
	public Config() {
		register(ParamController.class);
	}

}
