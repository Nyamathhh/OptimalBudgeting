package com.optily.OptimalBudgeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.optily.OptimalBudgeting.entities")
@ComponentScan("com.optily")
public class OptimalBudgetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimalBudgetingApplication.class, args);
	}

}
