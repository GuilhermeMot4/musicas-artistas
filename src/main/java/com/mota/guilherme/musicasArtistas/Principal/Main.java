package com.mota.guilherme.musicasArtistas.Principal;

import com.mota.guilherme.musicasArtistas.model.Artista;
import com.mota.guilherme.musicasArtistas.model.Musica;
import com.mota.guilherme.musicasArtistas.repository.ArtistaRepository;
import com.mota.guilherme.musicasArtistas.repository.MusicaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private Scanner teclado = new Scanner(System.in);

    private final ArtistaRepository artistaRepository;
    private final MusicaRepository musicaRepository;

    public Main(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void exibeMenu(){

        while (true) {
            System.out.println("1 - Cadastrar artista");
            System.out.println("2 - Cadastrar música");
            System.out.println("3 - Listar músicas");
            System.out.println("4 - Buscar músicas por artista");
            System.out.println("5 - Listar artistas");
            System.out.println("6 - Sair");

            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;

                case 2:
                    cadastrarMusica();
                    break;

                case 3:
                    listarMusicas();
                    break;

                case 4:
                    buscarMusicasPorArtista();
                    break;

                case 5:
                    listarArtistas();
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }
    }

    private void buscarMusicasPorArtista() {
        listarArtistas();

        System.out.println("Digite o código do artista:");
        var codigoArtista  = teclado.nextLong();
        teclado.nextLine();

        Optional<Artista> artista = buscaArtista(codigoArtista);
        if (artista.isPresent()){
            System.out.println("Digite um trecho da musica:");
            var trechoMusica  = teclado.nextLine();
            List<Musica> musicasEncontradas = musicaRepository.findByNomeContainingIgnoreCase(trechoMusica);
            if (!musicasEncontradas.isEmpty()){
                musicasEncontradas.forEach(System.out::println);
            }else{
                System.out.println("Nenhuma musica encontrada");
            }

        }else{
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        musicas.forEach(System.out::println);
    }

    private void cadastrarMusica() {

        System.out.println("Digite o nome da música:");
        var nomeMusica = teclado.nextLine();

        listarArtistas();

        System.out.println("Digite o código do artista:");
        var codigoArtista  = teclado.nextLong();

        Optional<Artista> artista = buscaArtista(codigoArtista);
        if (artista.isPresent()){
            Musica musica = new Musica(nomeMusica, artista.get());
            musicaRepository.save(musica);
        }else{
            System.out.println("Artista não encontrado");
        }

    }

    private void cadastrarArtista() {

        System.out.println("Digite o nome do artista:");

        var nomeArtista = teclado.nextLine();
        Artista artista = new Artista(nomeArtista);
        artistaRepository.save(artista);

    }

    private Optional<Artista> buscaArtista(Long codigoArtista){

        return artistaRepository.findById(codigoArtista);

    }

    private void listarArtistas(){
        List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(System.out::println);
    }
}


