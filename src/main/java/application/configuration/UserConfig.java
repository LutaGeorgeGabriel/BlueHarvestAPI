package application.configuration;

import application.repository.UserRepo;
import application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserService userService() {
        return new UserService();
    }

    @Bean
    UserRepo userRepo() {
        return new UserRepo();
    }
}
