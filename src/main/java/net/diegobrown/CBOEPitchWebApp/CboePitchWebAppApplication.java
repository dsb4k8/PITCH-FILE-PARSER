package net.diegobrown.CBOEPitchWebApp;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.diegobrown.controller.FileController;

@SpringBootApplication
@ComponentScan({"net.diegobrown.controller", "controller"})
@ComponentScan({"net.diegobrown.service", "service"})
@EntityScan("net.diegobrown.domain")
@EnableJpaRepositories("net.diegobrown.domain")

public class CboePitchWebAppApplication {

	public static void main(String[] args) {
		new File(FileController.uploadDirectory).mkdir();
		SpringApplication.run(CboePitchWebAppApplication.class, args);
	}

}
