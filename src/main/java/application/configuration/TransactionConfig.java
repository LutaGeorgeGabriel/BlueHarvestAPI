package application.configuration;

import application.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {
    @Bean
    TransactionService transactionService() {
        return new TransactionService();
    }
}
