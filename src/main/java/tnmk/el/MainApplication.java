package tnmk.el;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({ "tnmk.el", "tnmk.common", "tnmk.infrastructure" })
//Have to add this annotation because the repositories in 'infrastructure' package are not in the inside the package of MainApplication
@EnableMongoRepositories({ "tnmk.el", "tnmk.common", "tnmk.infrastructure" })
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
