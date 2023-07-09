package com.example.demomultiplefileuploan;

import com.example.demomultiplefileuploan.models.ClientFile;
import com.example.demomultiplefileuploan.repository.ArchivoRepository;
import com.example.demomultiplefileuploan.repository.ClientFileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMultipleFileUploanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMultipleFileUploanApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientFileRepository clientFileRepository, ArchivoRepository archivoRepository){
		return args -> {
			ClientFile clientFile = new ClientFile("rtik");
			clientFileRepository.save(clientFile);
		};
	}
}
