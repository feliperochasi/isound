package br.com.feliperochasi.isound.repository;

import br.com.feliperochasi.isound.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
