package ru.rsreu.hobbies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.hobbies.data.HobbyRepository;
import ru.rsreu.hobbies.data.UserRepository;

@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(HobbyRepository repo,
                                        UserRepository userRepo, PasswordEncoder encoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Hobby("S1", "С понедельника", Hobby.Type.SUPPOSE_START_TIME));
                repo.save(new Hobby("S2", "Завтра точно начну", Hobby.Type.SUPPOSE_START_TIME));
                repo.save(new Hobby("B1", "3 раза в неделю", Hobby.Type.BUSYNESS));
                repo.save(new Hobby("B2", "1 раз в неделю", Hobby.Type.BUSYNESS));
                repo.save(new Hobby("B3", "6 раз в нееделю", Hobby.Type.BUSYNESS));
                repo.save(new Hobby("K1", "Спорт", Hobby.Type.KIND));
                repo.save(new Hobby("K2", "Творчество", Hobby.Type.KIND));
                repo.save(new Hobby("K3", "Самообразование", Hobby.Type.KIND));

                userRepo.save(new User("fff", encoder.encode("fff"),
                        "Craig Walls",  "123-123-1234"));
            }
        };
    }
}
