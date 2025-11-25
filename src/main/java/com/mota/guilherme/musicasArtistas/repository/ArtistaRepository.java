package com.mota.guilherme.musicasArtistas.repository;

import com.mota.guilherme.musicasArtistas.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
