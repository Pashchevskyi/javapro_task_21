package ua.ithillel.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.ithillel.lms.service.StoreService;

/**
 * Hello world!
 */
@SpringBootApplication
public class SprBootApplication {

  @Autowired
  private StoreService storeService;

  public static void main(String[] args) {
    SpringApplication.run(SprBootApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    storeService.buy();
  }
}
