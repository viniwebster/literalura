package com.viniwebs.literalura;

import com.viniwebs.literalura.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Principal implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Main main = new Main();
        main.menu();
    }
}
