package com.ankur.stockbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockBrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockBrokerApplication.class, args);
  }

}
