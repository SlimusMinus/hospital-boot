package aston.group86.hospitalboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class HospitalBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(HospitalBootApplication.class, args);
  }

}
