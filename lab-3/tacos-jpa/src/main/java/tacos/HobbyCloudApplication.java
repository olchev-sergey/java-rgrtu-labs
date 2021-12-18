package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tacos.Hobby.Type;
import tacos.data.HobbyRepository;

@SpringBootApplication
public class HobbyCloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(HobbyCloudApplication.class, args);
  }

  @Bean
  public CommandLineRunner dataLoader(HobbyRepository repo) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        repo.save(new Hobby("S1", "С понедельника", Type.SUPPOSE_START_TIME));
        repo.save(new Hobby("S2", "Завтра точно начну", Type.SUPPOSE_START_TIME));
        repo.save(new Hobby("B1", "3 раза в неделю", Type.BUSYNESS));
        repo.save(new Hobby("B2", "1 раз в неделю", Type.BUSYNESS));
        repo.save(new Hobby("B3", "6 раз в нееделю", Type.BUSYNESS));
        repo.save(new Hobby("K1", "Спорт", Type.KIND));
        repo.save(new Hobby("K2", "Творчество", Type.KIND));
        repo.save(new Hobby("K3", "Самообразование", Type.KIND));
      }
    };
  }
  
}
