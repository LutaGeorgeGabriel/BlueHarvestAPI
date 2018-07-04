package application.configuration;

import application.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {
    @Bean
    AccountService accountService() {
        return new AccountService();
    }
}
