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
      log.info("Preloading " + repository.save(new Price(1, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
          LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 0, (float) (35.50), "EUR")));
      log.info("Preloading " + repository.save(new Price(2, 1, LocalDateTime.parse("2020-06-14T15:00:00"),
          LocalDateTime.parse("2020-06-14T18:30:00"), 35455, 1, (float) (25.45), "EUR")));
      log.info("Preloading " + repository.save(new Price(3, 1, LocalDateTime.parse("2020-06-15T00:00:00"),
          LocalDateTime.parse("2020-06-15T11:00:00"), 35455, 1, (float) (30.50), "EUR")));
      log.info("Preloading " + repository.save(new Price(4, 1, LocalDateTime.parse("2020-06-15T16:00:00"),
          LocalDateTime.parse("2020-12-31T23:59:59"), 35455, 1, (float) (38.95), "EUR")));

    };
  }
}