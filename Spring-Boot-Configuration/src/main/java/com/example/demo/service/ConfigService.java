package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.demo.model.Team;

@Configuration
@PropertySource("classpath:team.properties")
public class ConfigService {

	@Bean("team1")
	public Team getTeam() {
		return new Team();
	}
}
