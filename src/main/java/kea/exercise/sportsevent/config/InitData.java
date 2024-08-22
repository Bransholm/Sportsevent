package kea.exercise.sportsevent.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            System.out.println("Init data is created");
        }
}
