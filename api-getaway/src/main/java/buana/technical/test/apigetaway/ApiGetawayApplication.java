package buana.technical.test.apigetaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApiGetawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetawayApplication.class, args);
	}

}
