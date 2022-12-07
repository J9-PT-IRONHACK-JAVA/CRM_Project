package com.example.crm_project;

import com.example.crm_project.Services.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrmProjectApplication.class, args);
    }

    @Autowired
    private Menu menu;

    @Override
    public void run(String... args) {
        //menu.mainMenu();
    }


}
