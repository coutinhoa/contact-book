package com.example.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Contact("Bilbo Baggins",11111, "b@email.com")));
            log.info("Preloading " + repository.save(new Contact("Frodo Baggins", 22222, "f@email.com")));
            log.info("Preloading " + repository.save(new Contact("Cate", 33333, "c@email.com")));
            log.info("Preloading " + repository.save(new Contact("Diana", 44444, "d@email.com")));
            log.info("Preloading " + repository.save(new Contact("qwertz", 55555, "q@email.com")));
        };
    }
}
