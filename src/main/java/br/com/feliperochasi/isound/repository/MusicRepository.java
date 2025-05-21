package br.com.feliperochasi.isound.repository;

import br.com.feliperochasi.isound.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {
    Optional<Music> findByTitleContainingIgnoreCase(String title);
}
