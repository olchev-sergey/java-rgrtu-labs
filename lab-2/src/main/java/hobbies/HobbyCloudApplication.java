package hobbies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // <1>
public class HobbyCloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(HobbyCloudApplication.class, args); // <2>
  }

}
