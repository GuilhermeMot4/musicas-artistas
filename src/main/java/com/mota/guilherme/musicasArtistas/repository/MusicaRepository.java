package com.mota.guilherme.musicasArtistas.repository;

import com.mota.guilherme.musicasArtistas.model.Artista;
import com.mota.guilherme.musicasArtistas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    List<Musica> findByNomeContainingIgnoreCase(String trechoMusca);
}
