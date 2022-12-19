package com.example.contacts;

import com.example.contacts.models.Contact;
import com.example.contacts.repository.ContactRepository;
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
            /*log.info("Preloading " + repository.save(new Contact("Bilbo Baggins","11111", "b@email.com")));
            log.info("Preloading " + repository.save(new Contact("Frodo Baggins", "22222", "f@email.com")));
            log.info("Preloading " + repository.save(new Contact("Cate", "33333", "cate@email.com")));
            log.info("Preloading " + repository.save(new Contact("Diana", "44444", "di@email.com")));
            log.info("Preloading " + repository.save(new Contact("qwertz", "55555", "qw@email.com")));
            log.info("Preloading " + repository.save(new Contact("Anne","12222", "a@email.com")));
            log.info("Preloading " + repository.save(new Contact("Barbie", "112222", "b@email.com")));
            log.info("Preloading " + repository.save(new Contact("Charlie", "133333", "c@email.com")));
            log.info("Preloading " + repository.save(new Contact("Dimitri", "14444", "d@email.com")));
            log.info("Preloading " + repository.save(new Contact("Francis", "155555", "f@email.com")));
            log.info("Preloading " + repository.save(new Contact("Gwen","31111", "g@email.com")));
            log.info("Preloading " + repository.save(new Contact("Harry", "25222", "h@email.com")));
            log.info("Preloading " + repository.save(new Contact("Iris", "34433", "i@email.com")));
            log.info("Preloading " + repository.save(new Contact("John", "46744", "j@email.com")));
            log.info("Preloading " + repository.save(new Contact("Kate", "58955", "k@email.com")));
            log.info("Preloading " + repository.save(new Contact("Lili","11281", "l@email.com")));
            log.info("Preloading " + repository.save(new Contact("Marco", "25322", "m@email.com")));
            log.info("Preloading " + repository.save(new Contact("Nancy", "39333", "n@email.com")));
            log.info("Preloading " + repository.save(new Contact("Olivia", "95444", "o@email.com")));
            log.info("Preloading " + repository.save(new Contact("Phil", "55665", "p@email.com")));
            log.info("Preloading " + repository.save(new Contact("Q","11147", "q@email.com")));
            log.info("Preloading " + repository.save(new Contact("Ruth", "21122", "r@email.com")));
            log.info("Preloading " + repository.save(new Contact("Sara", "36633", "s@email.com")));
            log.info("Preloading " + repository.save(new Contact("Tamara", "63444", "t@email.com")));
            log.info("Preloading " + repository.save(new Contact("Ursula", "52655", "u@email.com")));
            log.info("Preloading " + repository.save(new Contact("Mary", "25452", "mary@email.com")));
            log.info("Preloading " + repository.save(new Contact("Hein", "39223", "he@email.com")));
            log.info("Preloading " + repository.save(new Contact("Bjarn", "95444", "bj@email.com")));
            log.info("Preloading " + repository.save(new Contact("Paul", "58665", "pa@email.com")));
            log.info("Preloading " + repository.save(new Contact("Brandon","88847", "br@email.com")));
            log.info("Preloading " + repository.save(new Contact("Daniel", "21892", "d@email.com")));
            log.info("Preloading " + repository.save(new Contact("Chloe", "36449", "ch@email.com")));
            log.info("Preloading " + repository.save(new Contact("Victoria", "63888", "vic@email.com")));
            log.info("Preloading " + repository.save(new Contact("Anastacia", "52683", "an@email.com")));*/
        };
    }
}
