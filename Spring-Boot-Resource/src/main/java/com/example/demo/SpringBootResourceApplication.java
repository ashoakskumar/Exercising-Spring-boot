package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import com.example.demo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class SpringBootResourceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResourceApplication.class, args);
	}

	@Autowired
	ResourceLoader resourceLoader;
	@Value("file:data.txt")
	Resource resource2;
	@Value("file:input/data*.txt")
	Resource[] resources;
	@Value("classpath:sample.json")
	Resource resourceClassPath;
	@Override
	public void run(String... args) throws Exception {
		
		// Resource loader example
		Resource resource1 = resourceLoader.getResource("classpath:data.txt");
		InputStream inputStreamLoader = resource1.getInputStream(); try { byte[] bdata =
				  FileCopyUtils.copyToByteArray(inputStreamLoader); String data = new String(bdata,
				  StandardCharsets.UTF_8); System.out.println(data); } catch(IOException ioe) {
				  ioe.printStackTrace(); } 
	
	
		   Resource resourceFile = resourceLoader.getResource("file:data.txt");
		  for(Resource resource : resources) { InputStream inputStream =
		  resource.getInputStream(); try { byte[] bdata =
		  FileCopyUtils.copyToByteArray(inputStream); String data = new String(bdata,
		  StandardCharsets.UTF_8); System.out.println(data); } catch(IOException ioe) {
		  ioe.printStackTrace(); } }
		 
		ObjectMapper mapper = new ObjectMapper();
		Person person = mapper.readValue(resourceClassPath.getFile(), Person.class);
		System.out.println(person);
		
	}

}
