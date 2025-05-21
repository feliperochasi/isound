package br.com.feliperochasi.isound.repository;

import br.com.feliperochasi.isound.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByTitleContainingIgnoreCase(String albumSearch);
}
