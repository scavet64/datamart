package com.team12.datamart;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.team12.datamart.domain.DateDimension;
import com.team12.datamart.generation.DateDimensionGeneration;
import com.team12.datamart.service.DateDimensionService;

@SpringBootApplication
public class DatamartApplication {

	@Autowired
	private DateDimensionService dateService;

	@Autowired
	private DateDimensionGeneration dateGenerator;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DatamartApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			try {
				logger.info("Starting Application!");

				List<DateDimension> dates = dateGenerator.getDataForYear(2019);
				dateService.saveDateDimensions(dates);

				logger.info(dateService.getCount().toString());

				logger.info("Finished!");
			} catch (Exception ex) {
				logger.error("Bad things", ex);
			}
		};
	}

}
