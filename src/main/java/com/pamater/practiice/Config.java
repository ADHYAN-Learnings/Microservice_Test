package com.pamater.practiice;



import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.pamater.practiice.controller.ParamController;
import com.pamater.practiice.controller.QueryParamController;
import com.pamater.practiice.controller.RequestParamController;

// Enable this code when you're using jersey details like @PathParm or @QueryParam
// Comment it out when you're using mvc annotations
/**
@Configuration
public class Config extends ResourceConfig {
	
	public Config() {
		register(ParamController.class);
		register(QueryParamController.class);
		register(RequestParamController.class);
	}

}
 **/