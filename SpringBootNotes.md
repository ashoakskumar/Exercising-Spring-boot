SpringBoot:-
1. It depends on the starter template that contains the collection of relavant trasitive dependencies to load external classes that are required to develop a application.
2. starter template - will avoid the version conflicts of dependency jar file
	example - <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-json</artifactId>
		</dependency>
3. Auto configuration - It scans the classpath then attempt to configure with beans
		example - @EnableBatchProcessing
		3.1 It’s “opinionated defaults configuration” approach helps you in configuring most important pieces behind the scene. Override them only when you need. Otherwise everything just works, perfectly. 
		It helps in avoiding boilerplate code, annotations and XML configurations.
4. Embedded tomcat server with Embedded Servlet Container -it include tomcat as embedded server dependency. It means you can run the Spring boot applications from the command prompt without needling complex server infrastructure.
5. Bootstrap the application - 	It enables the scanning of config classes, files and load them into spring context and and bootstrap the application based on application properties in application.properties file in /resources folder
