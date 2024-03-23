package com.example.baitaptuan1;

import com.example.baitaptuan1.model.modelIplm.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaiTapTuan1Application implements CommandLineRunner {


	@Autowired
	private Person person ;
	public static void main(String[] args) {
		SpringApplication.run(BaiTapTuan1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		person.out();
	}
}
