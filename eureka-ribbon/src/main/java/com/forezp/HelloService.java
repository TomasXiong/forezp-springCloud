package com.forezp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate; 
	
    @HystrixCommand(fallbackMethod = "hiError")  //对该方法创建了熔断器功能，并指定了hiError为falkbackMethod熔断方法
	public String hiService(String name) {
		//ribbon项目的hiService调用hi(client)项目的hiService,通过restTemplate,这就是rpc的调用，服务与服务之间相互调用
    	return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);  
	}
    
    public String hiError(String name) {
    	return "hi:"+name+" this is hystrix method";
    }

}
