package io.nextgen.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CourseApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApiApplication.class, args);
        System.out.println(SpringVersion.getVersion());

    }
}
