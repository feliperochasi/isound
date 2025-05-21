package br.com.feliperochasi.isound.main;

import br.com.feliperochasi.isound.model.Album;
import br.com.feliperochasi.isound.model.Artistic;
import br.com.feliperochasi.isound.model.Music;
import br.com.feliperochasi.isound.repository.AlbumRepository;
import br.com.feliperochasi.isound.repository.ArtisticRepository;
import br.com.feliperochasi.isound.repository.MusicRepository;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private final ArtisticRepository artisticRepository;
    private final AlbumRepository albumRepository;
    private final MusicRepository musicRepository;
    private Integer leave = 0;

    public Main(ArtisticRepository artisticRepository,
                AlbumRepository albumRepository,
                MusicRepository musicRepository) {
        this.artisticRepository = artisticRepository;
        this.albumRepository = albumRepository;
        this.musicRepository = musicRepository;
    }
    public void initIsound() {
        System.out.println("""
                
                
                ***************** Bem Vindo ao ISOUND *****************
                
                
                """);
        var option = -1;
        while (option != 9) {
            showMenu();
            option = scanner.nextInt();
            clearLine();
            readOption(option);
        }
    }

    private void showMenu() {
        System.out.println("""
                Selecione uma das opcoes abaixo para continuar
                
                1 - Cadastrar artista
                2 - Cadastrar musica
                3 - Cadastrar Album
                4 - Listar musicas
                5 - Buscar musica por artista
                6 - Buscar musica por album
                7 - Saber mais sobre artista
                8 - Saber mais sobre musica
                
                9 - Sair
                """);
    }

    private void readOption(Integer selectOption) {
        switch (selectOption) {
            case 1:
                createNewArtistic();
                break;
            case 2:
                createNewMusic();
                break;
            case 3:
                createNewAlbum();
                break;
            case 4:
                listAllMusics();
                break;
            case 5:
                searchMusicFromArtistic();
                break;
            case 6:
                searchMusicFromAlbum();
                break;
            case 7:
                queryArtisticIA();
                break;
            case 8:
                queryMusicIA();
                break;
            case 9:
                System.out.println("Encerrando....");
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                break;
        }


    }

    private void createNewArtistic() {
        leave = 0;
        while (leave == 0) {
            showTitleMessage("Cadastro de um novo artista");
            System.out.println("Nome do artista:");
            var name = scanner.nextLine();
            System.out.println("Tipo de artista:");
            var type = scanner.nextLine();
            System.out.println("Data de inicio da carreira:");
            var date = scanner.nextLine();
            var artistic = new Artistic(name, type, date);
            artisticRepository.save(artistic);
            repeat();
        }
    }

    private void createNewMusic() {
        leave = 0;
        while (leave == 0) {
            showTitleMessage("Cadastro de uma nova musica");
            var artistic = getArtisticFromDatabase();
            System.out.println("Para qual album deseja cadastrar essa musica?");
            var artisticAlbums = artistic.getAlbum();
            artisticAlbums.forEach(a -> {
                System.out.println("Nome do album: " + a.getTitle());
            });
            var searchAlbum = scanner.nextLine();
            var album = artistic.getAlbum().stream().filter(a -> a.getTitle().toLowerCase().contains(searchAlbum.toLowerCase())).findFirst();
            if (album.isPresent()) {
                var a = album.get();
                System.out.println("Digite o nome da musica:");
                var title = scanner.nextLine();
                System.out.println("Digite a duracao da musica:");
                var duration = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Digite a data de lancamento:");
                var date = scanner.nextLine();
                var music = new Music(title, duration, date, a, artistic);
                musicRepository.save(music);
            } else {
                System.out.println("Album nao encontrado, tente novamente!");
            }
            repeat();
        }
    }

    private void createNewAlbum() {
        leave = 0;
        while (leave == 0) {
            showTitleMessage("Cadastro de um novo album");
            var artistic = getArtisticFromDatabase();
            System.out.println("Digite o titulo do album:");
            var title = scanner.nextLine();
            System.out.println("Digite a data de lancamento:");
            var date = scanner.nextLine();
            var album = new Album(title, artistic, date);
            albumRepository.save(album);
            repeat();
        }
    }

    private void listAllMusics() {
        showTitleMessage("Lista musicas disponiveis");
        var musics = musicRepository.findAll();
        musics.forEach(m -> {
            System.out.printf("Musica: %s - Duracao %s - Album %s - Artista %s\n",
                    m.getTitle(),  m.getDuration(), m.getAlbum().getTitle(),
                    m.getArtistic().getName());
        });

    }

    private void searchMusicFromArtistic() {
        showTitleMessage("Lista musicas por artista");
        var artistic = getArtisticFromDatabase();
        artistic.getAlbum().forEach(a -> {
            System.out.println("\nMusicas do album: " + a.getTitle());
            a.getMusic().forEach(m -> {
                System.out.println("Musica: " + m.getTitle() + " Duracao: " + m.getDuration());
            });
        });
    }

    private void searchMusicFromAlbum() {
        showTitleMessage("Lista de musicas por album");
        System.out.println("Digite o album que deseja buscar");
        var albumSearch = scanner.nextLine();
        var album = albumRepository.findByTitleContainingIgnoreCase(albumSearch);
        album.ifPresent(a -> {
            System.out.println("Album: " + a.getTitle());
            a.getMusic().forEach(m -> {
                System.out.println("Musica: " + m.getTitle());
            });
        });
    }

    private void queryArtisticIA() {

    }

    private void queryMusicIA() {
    }

    private void clearLine() {
        scanner.nextLine();
    }

    private void showTitleMessage(String message) {
        System.out.println("***************** " + message + " *****************");
    }

    private Artistic getArtisticFromDatabase() {
        System.out.println("Pesquie pelo artista");
        var searchArtistic = scanner.nextLine();
        Optional<Artistic> resultArtistic = artisticRepository.findByNameContainingIgnoreCase(searchArtistic);
        if (resultArtistic.isPresent()) {
            return resultArtistic.get();
        }
        throw new IllegalArgumentException("Nenhum tipo de artista encontrado: " + searchArtistic);
    }

    private void repeat() {
        System.out.println("Deseja realizar mais um cadastro? (n/s)");
        var s = scanner.nextLine();
        if (!s.equalsIgnoreCase("s")) {
            leave = 1;
        }
    }

}
