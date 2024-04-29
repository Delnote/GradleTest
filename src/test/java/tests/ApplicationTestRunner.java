package tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pages")
public class ApplicationTestRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTestRunner.class, args);
    }

}
