package br.com.feliperochasi.isound.repository;

import br.com.feliperochasi.isound.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
