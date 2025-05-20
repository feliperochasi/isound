package br.com.feliperochasi.isound;

import br.com.feliperochasi.isound.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IsoundApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IsoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var initMain = new Main();
		initMain.initIsound();
	}
}
