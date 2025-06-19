package co.edu.udistrital.taller2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.udistrital")
public class Taller2Application {

    public static void main(String[] args) {
        SpringApplication.run(Taller2Application.class, args);
    }

}
