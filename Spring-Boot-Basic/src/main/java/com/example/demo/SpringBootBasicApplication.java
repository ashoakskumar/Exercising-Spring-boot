package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.bean.model.HelloMessage;
import com.example.demo.service.AddressService;
import com.example.demo.service.AutowireDIPropertyService;
import com.example.demo.service.AutowireDiService;
import com.example.demo.service.OptionalDependencyService;

@SpringBootApplication
public class SpringBootBasicApplication {
	
	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(SpringBootBasicApplication.class, args);
		//Get Bean by type
		HelloMessage msg1 = ctx.getBean(HelloMessage.class);
		System.out.println("Get bean By type: "+ msg1);
		//Get bean by name
		HelloMessage msg2 = ctx.getBean("myMessage",HelloMessage.class);
		System.out.println("Get bean By name: "+ msg2);
		
		// Autowire on constructor example 
		AutowireDiService service = ctx.getBean(AutowireDiService.class);
		service.printMsg();
		
		// Autowire On methods Example
		AutowireDIPropertyService service1 = ctx.getBean(AutowireDIPropertyService.class);
		service1.printMsg();
		// Autowire Qualifier
		AddressService dao = ctx.getBean(AddressService.class);
		dao.print();
		// Autowire optional
		
		OptionalDependencyService option = ctx.getBean(OptionalDependencyService.class);
		System.out.println(option.getService());
	}

}
