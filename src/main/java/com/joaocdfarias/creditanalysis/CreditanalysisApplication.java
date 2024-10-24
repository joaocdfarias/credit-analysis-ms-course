package com.joaocdfarias.creditanalysis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.joaocdfarias.creditanalysis.service.CreditAnalysisService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class CreditanalysisApplication {

	private CreditAnalysisService creditAnalysisService;

	public static void main(String[] args) {
		SpringApplication.run(CreditanalysisApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> creditAnalysisService.analyse(null);
	}

}
