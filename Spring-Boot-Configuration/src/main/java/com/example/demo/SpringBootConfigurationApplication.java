package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Person;
import com.example.demo.model.Team;

@SpringBootApplication
public class SpringBootConfigurationApplication {

	public static void main(String[] args) {
		final ApplicationContext ctx = SpringApplication.run(SpringBootConfigurationApplication.class, args);
		final Team team = ctx.getBean("team1",Team.class);
		System.out.println("--- Team ---");
		System.out.println(team);
		final Person person1 = ctx.getBean("person1",Person.class);
		System.out.println("--- Person1 ---");
		System.out.println(person1);
		final Person person2 = ctx.getBean("person2",Person.class);
		System.out.println("--- Person2 ---");
		System.out.println(person2);
	}

}
