package com.forezp;

import org.springframework.stereotype.Component;

@Component  //通过此注解注入到IOC容器中
public class SchedualServiceHiHystric implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "sorry:"+name+" this is hystrix 方法";
	}

}
