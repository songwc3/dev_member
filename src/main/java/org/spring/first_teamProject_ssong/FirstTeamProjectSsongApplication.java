package org.spring.first_teamProject_ssong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FirstTeamProjectSsongApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstTeamProjectSsongApplication.class, args);
	}

}
