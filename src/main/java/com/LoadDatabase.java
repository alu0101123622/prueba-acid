package com;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PriceRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Price(0, 1, LocalDateTime.parse("2015-02-20T06:30:00"),
          LocalDateTime.parse("2015-02-20T06:30:00"), 35455, 0, (float) (35.50), "EUR")));
    };
  }
}