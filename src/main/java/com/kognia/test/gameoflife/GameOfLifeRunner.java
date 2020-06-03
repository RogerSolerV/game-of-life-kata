package com.kognia.test.gameoflife;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.kognia.test.gameoflife"})
@EnableScheduling
@EnableAspectJAutoProxy
public class GameOfLifeRunner {

  public static void main(String[] args) {
    SpringApplication.run(GameOfLifeRunner.class, args);
  }

  @PostConstruct
  public void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
  }
}
