package com.example.crm_project;

import com.example.crm_project.Services.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrmProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Menu.mainMenu();
    }

}
