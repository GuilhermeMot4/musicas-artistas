package com.mota.guilherme.musicasArtistas;

import com.mota.guilherme.musicasArtistas.Principal.Main;
import com.mota.guilherme.musicasArtistas.repository.ArtistaRepository;
import com.mota.guilherme.musicasArtistas.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;

@SpringBootApplication
public class MusicasArtistasApplication implements CommandLineRunner {

    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    MusicaRepository musicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicasArtistasApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Main principal = new Main(artistaRepository, musicaRepository);
        principal.exibeMenu();

    }
}
