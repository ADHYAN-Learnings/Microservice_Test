package com.parameter.practice;



import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.parameter.practice.controller.ParamController;
import com.parameter.practice.controller.QueryParamController;
import com.parameter.practice.controller.RequestParamController;

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