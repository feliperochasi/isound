package br.com.feliperochasi.isound.repository;

import br.com.feliperochasi.isound.model.Artistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtisticRepository extends JpaRepository<Artistic, Long> {
    Optional<Artistic> findByNameContainingIgnoreCase(String artistic);
}
