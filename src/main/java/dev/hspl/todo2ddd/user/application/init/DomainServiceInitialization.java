package dev.hspl.todo2ddd.user.application.init;

import dev.hspl.todo2ddd.user.domain.service.PasswordProtector;
import dev.hspl.todo2ddd.user.domain.service.UserAuthenticationService;
import dev.hspl.todo2ddd.user.domain.service.UserUniquenessChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class DomainServiceInitialization {
    @Bean
    public UserAuthenticationService userAuthenticationService(
            PasswordProtector passwordProtector,
            UserUniquenessChecker userUniquenessChecker
    ) {
        return new UserAuthenticationService(passwordProtector,userUniquenessChecker);
    }
}
