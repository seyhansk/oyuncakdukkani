package com.example.demo;
import com.example.demo.entity.Oyuncak;
import com.example.demo.repository.OyuncakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class H5220063Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(H5220063Application.class, args);
	}

	@Autowired
	OyuncakRepository oyuncakRepository;

	@Override
	public void run(String... args) throws Exception {
		Oyuncak oyuncak = new Oyuncak();
		oyuncak.setAd("Barbie");
		oyuncak.setAlisTarihi(LocalDate.now());
		oyuncak.setAlisFiyati(500.00);
		oyuncak.setTur("Bebek");
		oyuncak.setDesi(10);
		oyuncak.setNotlar("Kız Bebek");
		oyuncakRepository.save(oyuncak);
	}
}
