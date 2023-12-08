package dev.azizoglusergen.cknewsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ConvertKitProperties.class)
@SpringBootApplication
public class CkNewsletterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CkNewsletterApplication.class, args);
    }

}
