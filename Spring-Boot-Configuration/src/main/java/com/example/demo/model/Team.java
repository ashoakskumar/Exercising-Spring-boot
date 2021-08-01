package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@ConfigurationProperties
@Component
@Data
@ToString
public class Team {

	private String team;
	private int teamSize;
	private String teamLeader;
	
	
}
