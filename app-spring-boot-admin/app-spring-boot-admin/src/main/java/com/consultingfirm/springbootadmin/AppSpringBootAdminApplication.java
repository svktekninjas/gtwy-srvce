package com.consultingfirm.springbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AppSpringBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringBootAdminApplication.class, args);
	}

}
