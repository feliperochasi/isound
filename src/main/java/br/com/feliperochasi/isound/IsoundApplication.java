package br.com.feliperochasi.isound;

import br.com.feliperochasi.isound.main.Main;
import br.com.feliperochasi.isound.repository.AlbumRepository;
import br.com.feliperochasi.isound.repository.ArtisticRepository;
import br.com.feliperochasi.isound.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IsoundApplication implements CommandLineRunner {
	@Autowired
	private ArtisticRepository artisticRepository;
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(IsoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var initMain = new Main(artisticRepository, albumRepository, musicRepository);
		initMain.initIsound();
	}
}
